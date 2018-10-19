package pro.vinyard.project.entity.peristence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Calendar;

import static org.junit.Assert.*;

public class CPCarTest {
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	
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
		CPCar newCar = new CPCar();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newCar.setFiscalHorsepower((int) (Math.random() * 1000));
			newCar.setModel("test");
			newCar.setRegistrationDate(Calendar.getInstance().getTime());
			
			CPEmployee owner = new CPEmployee();
			owner.setBirthDate(Calendar.getInstance().getTime());
			owner.setFirstName("Owner");
			owner.setLastName("Own");
			owner.setLicenceDate(Calendar.getInstance().getTime());
			
			owner.setGender("M");
			owner.setMail("mail@vinyard.pro");
			owner.setLicenceNumber("licence_number");
			manager.persist(owner);
			newCar.setEmployee(owner);
			manager.persist(newCar);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		
		CPCar cpCar = manager.find(CPCar.class, newCar.getId());
		
		assertNotNull("Car cannot find by id : " + newCar.getId(), cpCar);
		
		assertEquals("fiscalHorsePower not equal : " + newCar.getFiscalHorsepower() + " == " + cpCar.getFiscalHorsepower(), newCar.getFiscalHorsepower(), cpCar.getFiscalHorsepower());
		
		assertSame("Model not equal : " + newCar.getModel() + " == " + cpCar.getModel(), newCar.getModel(), cpCar.getModel());
		
		assertSame("Model not equal : " + newCar.getRegistrationDate() + " == " + cpCar.getRegistrationDate(), newCar.getRegistrationDate(), cpCar.getRegistrationDate());
		
		assertEquals("id not equal : " + newCar.getId() + " == " + cpCar.getId(), newCar.getId(), cpCar.getId());
		
		assertNotNull("employee owner is null", cpCar.getEmployee());
		
		if(cpCar.getEmployee() != null) {
			assertEquals("wrong employee", "Owner", cpCar.getEmployee().getFirstName());
		}
	}
}