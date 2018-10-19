package pro.vinyard.project.entity.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CPPhoneNumberTest {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	
	@Before
	public void setUp() throws Exception {
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
		CPPhoneNumber newPhoneNumber = new CPPhoneNumber();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newPhoneNumber.setPhoneNumber("118 218");
			newPhoneNumber.setPhoneType("bureau");
			manager.persist(newPhoneNumber);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		
		CPPhoneNumber cpPhoneNumber = manager.find(CPPhoneNumber.class, newPhoneNumber.getId());
		
		assertNotNull("Car cannot find by id : " + newPhoneNumber.getId(), cpPhoneNumber);
		
		assertTrue("phoneNumber not equal : " + newPhoneNumber.getPhoneNumber() + " == " + cpPhoneNumber.getPhoneNumber(), newPhoneNumber.getPhoneNumber() == cpPhoneNumber.getPhoneNumber());
		
		assertTrue("phoneType not equal : " + newPhoneNumber.getPhoneType() + " == " + cpPhoneNumber.getPhoneType(), newPhoneNumber.getPhoneType() == cpPhoneNumber.getPhoneType());
		
		assertTrue("id not equal : " + newPhoneNumber.getId() + " == " + cpPhoneNumber.getId(), newPhoneNumber.getId() == cpPhoneNumber.getId());
	}
}