package pro.vinyard.project.entity.peristence;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CPLocationTest {
	
	private EntityManager manager;
	
	@Before
	public void setUp() throws Exception {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("pgsql");
		assertNotNull(factory);
		
		this.manager = factory.createEntityManager();
		
		assertNotNull(this.manager);
	}
	
	@After
	public void tearDown() throws Exception {
		this.manager.close();
		
		assertFalse(manager.isOpen());
	}
	
	public void persist() {
		CPLocation newLocation = new CPLocation();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newLocation.setLat(48.115243);
			newLocation.setLng(-1.638364);
			manager.persist(newLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPLocation cpLocation = manager.find(CPLocation.class, newLocation.getId());
		
		assertNotNull("Car cannot find by id : " + newLocation.getId(), cpLocation);
		
		assertTrue("lat not equal : " + newLocation.getLat() + " == " + cpLocation.getLat(), newLocation.getLat() == cpLocation.getLat());
		
		assertTrue("lng not equal : " + newLocation.getLng() + " == " + cpLocation.getLng(), newLocation.getLng() == cpLocation.getLng());
		
		assertTrue("id not equal : " + newLocation.getId() + " == " + cpLocation.getId(), newLocation.getId() == cpLocation.getId());
	}
}