package pro.vinyard.project.entity.peristence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
	}
	
	@Test
	public void getId() {
		CPCar test = new CPCar();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.setFiscalHorsepower((int) (Math.random() * 1000));
			manager.persist(test);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPCar test2 = manager.find(CPCar.class, test.getId());
		
		assertNotNull("find null", test2);
		
		assertTrue("test find : " + test.getFiscalHorsepower() + " " + test2.getFiscalHorsepower(), test2.getFiscalHorsepower() == test.getFiscalHorsepower());
		
		manager.close();
	}
	
	@Test
	public void setId() {
	}
	
	@Test
	public void getModel() {
	}
	
	@Test
	public void setModel() {
	}
	
	@Test
	public void getFiscalHorsepower() {
	}
	
	@Test
	public void setFiscalHorsepower() {
	}
	
	@Test
	public void getRegistrationDate() {
	}
	
	@Test
	public void setRegistrationDate() {
	}
	
	@Test
	public void getEmployee() {
	}
	
	@Test
	public void setEmployee() {
	}
}