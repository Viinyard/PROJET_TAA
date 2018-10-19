package pro.vinyard.project.entity.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CPDeplacementTest {
	
	private EntityManager manager;
	
	@Before
	public void setUp() {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("pgsql");
		assertNotNull(factory);
		
		this.manager = factory.createEntityManager();
		
		assertNotNull(this.manager);
	}
	
	@After
	public void tearDown() {
		this.manager.close();
		
		assertFalse(manager.isOpen());
	}
	
	@Test
	public void persist() {
		CPDeplacement newDeplacement = new CPDeplacement();
		CPAddress newAddressArrivee = new CPAddress();
		CPAddress newAddressDepart = new CPAddress();
		CPCar newCar = new CPCar();
		CPEmployee newEmployee = new CPEmployee();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newAddressDepart.setLabel("depart");
			manager.persist(newAddressDepart);
			
			newAddressArrivee.setLabel("arrivee");
			manager.persist(newAddressArrivee);
			
			newCar.setFiscalHorsepower(333);
			manager.persist(newCar);
			
			newEmployee.setFirstName("john");
			manager.persist(newEmployee);
			
			newDeplacement.setAddressDepart(newAddressDepart);
			newDeplacement.setAddressArrivee(newAddressArrivee);
			newDeplacement.setCar(newCar);
			newDeplacement.setEmployee(newEmployee);
			manager.persist(newDeplacement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPDeplacement cpDeplacement = manager.find(CPDeplacement.class, newDeplacement.getID());
		
		assertNotNull("Deplacement cannot find by id : " + newDeplacement.getID(), cpDeplacement);
		
		assertEquals("AddressArrivee not equal : " + newDeplacement.getAddressArrivee().getLabel() + " == " + cpDeplacement.getAddressArrivee().getLabel(), newDeplacement.getAddressArrivee().getLabel(), cpDeplacement.getAddressArrivee().getLabel());
		
		assertEquals("AddressDepart not equal : " + newDeplacement.getAddressDepart().getLabel() + " == " + cpDeplacement.getAddressDepart().getLabel(), newDeplacement.getAddressDepart().getLabel(), cpDeplacement.getAddressDepart().getLabel());
		
		assertEquals("Car not equal : " + newDeplacement.getCar().getFiscalHorsepower() + " == " + cpDeplacement.getCar().getFiscalHorsepower(), newDeplacement.getCar().getFiscalHorsepower(), cpDeplacement.getCar().getFiscalHorsepower());
		
		assertEquals("Employee not equal : " + newDeplacement.getEmployee().getFirstName() + " == " + cpDeplacement.getEmployee().getFirstName(), newDeplacement.getEmployee().getFirstName(), cpDeplacement.getEmployee().getFirstName());
		
		CPAddress cpAddressDepart = manager.find(CPAddress.class, newAddressDepart.getId());
		
		assertNotNull("Address cannot find by id : " + newAddressDepart.getId(), cpAddressDepart);
		
		assertEquals("Address not equal : " + newAddressDepart.getLabel() + " == " + cpAddressDepart.getLabel(), newAddressDepart.getLabel(), cpAddressDepart.getLabel());
		
		CPAddress cpAddressArrivee = manager.find(CPAddress.class, newAddressArrivee.getId());
		
		assertNotNull("Address cannot find by id : " + newAddressArrivee.getId(), cpAddressArrivee);
		
		assertEquals("Address not equal : " + newAddressArrivee.getLabel() + " == " + cpAddressArrivee.getLabel(), newAddressArrivee.getLabel(), cpAddressArrivee.getLabel());
		
		CPCar cpCar = manager.find(CPCar.class, newCar.getId());
		
		assertNotNull("Car cannot find by id : " + newCar.getId(), cpCar);
		
		assertEquals("Car not equal : " + newCar.getFiscalHorsepower() + " == " + cpCar.getFiscalHorsepower(), newCar.getFiscalHorsepower(), cpCar.getFiscalHorsepower());
		
		CPEmployee cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee cannot find by id : " + newAddressDepart.getId(), cpEmployee);
		
		assertEquals("Employee not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
		
		tx.begin();
		try {
			manager.remove(newDeplacement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		cpAddressDepart= manager.find(CPAddress.class, newAddressDepart.getId());
		
		assertNotNull("Address(depart) can't find by id : " + newAddressDepart.getId(), cpAddressDepart);
		
		cpAddressArrivee = manager.find(CPAddress.class, newAddressArrivee.getId());
		
		assertNotNull("Address(arrivee) can't find by id : " + newAddressArrivee.getId(), cpAddressArrivee);
		
		cpCar = manager.find(CPCar.class, newCar.getId());
		
		assertNotNull("Car can't find by id : " + newCar.getId(), cpCar);
		
		cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee can't find by id : " + newEmployee.getId(), cpEmployee);
	}
}
