package pro.vinyard.project.entity.peristence;

import com.google.maps.model.LatLng;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CPLocationTest {
	
	private EntityManager manager;
	private EntityManagerFactory emf;
	
	@Before
	public void setUp() {
		this.emf =
				Persistence.createEntityManagerFactory("pgsql");
		assertNotNull(this.emf);
		this.manager = this.emf.createEntityManager();
		assertNotNull(this.manager);
	}
	
	@After
	public void tearDown() {
		this.manager.close();
		assertFalse(manager.isOpen());
		
		this.emf.close();
		assertFalse(this.emf.isOpen());
	}
	
	@Test
	public void persist() {
		CPLocation newLocation = new CPLocation();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newLocation.setLat(48.115243);
			newLocation.setLng(-1.638364);
			manager.persist(newLocation);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		
		CPLocation cpLocation = manager.find(CPLocation.class, newLocation.getId());
		
		assertNotNull("Car cannot find by id : " + newLocation.getId(), cpLocation);
		
		assertEquals("lat not equal : " + newLocation.getLat() + " == " + cpLocation.getLat(), newLocation.getLat(), cpLocation.getLat(), 0.0);
		
		assertEquals("lng not equal : " + newLocation.getLng() + " == " + cpLocation.getLng(), newLocation.getLng(), cpLocation.getLng(), 0.0);
		
		assertEquals("id not equal : " + newLocation.getId() + " == " + cpLocation.getId(), newLocation.getId(), cpLocation.getId());
	}
	
	@Test
	public void withNullArgument() {
		CPLocation newLocation = new CPLocation(null);
		assertEquals(0d, newLocation.getLat(), 0.0);
		assertEquals(0d, newLocation.getLng(), 0.0);
	}
	
	@Test
	public void withLatLng() {
		CPLocation newLocation = new CPLocation(new LatLng(0, 0));
		assertEquals(0d, newLocation.getLng(), 0.0);
		assertEquals(0d, newLocation.getLat(), 0.0);
	}
}