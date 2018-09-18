package pro.vinyard.project.entity.peristence;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CPPhoneNumberTest {
	
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
		CPPhoneNumber newPhoneNumber = new CPPhoneNumber();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newPhoneNumber.setPhoneNumber("118 218");
			newPhoneNumber.setPhoneType("bureau");
			manager.persist(newPhoneNumber);
		} catch (Exception e) {
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