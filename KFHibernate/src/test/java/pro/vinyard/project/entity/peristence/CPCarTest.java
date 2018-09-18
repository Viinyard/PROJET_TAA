package pro.vinyard.project.entity.peristence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CPCarTest {
	
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
	
	@Test
	public void persist() {
		CPCar newCar = new CPCar();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newCar.setFiscalHorsepower((int) (Math.random() * 1000));
			newCar.setModel("test");
			newCar.setRegistrationDate(Calendar.getInstance().getTime());
			manager.persist(newCar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPCar cpCar = manager.find(CPCar.class, newCar.getId());
		
		assertNotNull("Car cannot find by id : " + newCar.getId(), cpCar);
		
		assertTrue("fiscalHorsePower not equal : " + newCar.getFiscalHorsepower() + " == " + cpCar.getFiscalHorsepower(), newCar.getFiscalHorsepower() == cpCar.getFiscalHorsepower());
		
		assertTrue("Model not equal : " + newCar.getModel() + " == " + cpCar.getModel(), newCar.getModel() == cpCar.getModel());
		
		assertTrue("Model not equal : " + newCar.getRegistrationDate() + " == " + cpCar.getRegistrationDate(), newCar.getRegistrationDate() == cpCar.getRegistrationDate());
		
		assertTrue("id not equal : " + newCar.getId() + " == " + cpCar.getId(), newCar.getId() == cpCar.getId());
	}
}