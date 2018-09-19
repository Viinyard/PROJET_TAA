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

public class CPEmployeeTest {
	
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
		CPEmployee newEmployee = new CPEmployee();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newEmployee.setFirstName("john");
			newEmployee.setLastName("smith");
			newEmployee.setGender("male");
			newEmployee.setBirthDate(Calendar.getInstance().getTime());
			manager.persist(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPEmployee cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee cannot find by id : " + newEmployee.getId(), cpEmployee);
		
		assertEquals("Firstname not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
		
		assertEquals("Lastname not equal : " + newEmployee.getLastName() + " == " + cpEmployee.getLastName(), newEmployee.getLastName(), cpEmployee.getLastName());
		
		assertEquals("Gender not equal : " + newEmployee.getGender() + " == " + cpEmployee.getGender(), newEmployee.getGender(), cpEmployee.getGender());
		
		assertEquals("Date not equal : " + newEmployee.getBirthDate() + " == " + cpEmployee.getBirthDate(), newEmployee.getBirthDate(), cpEmployee.getBirthDate());
		
	}
	
	@Test
	public void deleteAttachment() {
		CPEmployee newEmployee = new CPEmployee();
		CPAttachment newAttachment = new CPAttachment();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newEmployee.setFirstName("john");
			newEmployee.setLastName("smith");
			newEmployee.setGender("male");
			newEmployee.setBirthDate(Calendar.getInstance().getTime());
			
			newAttachment.setType("file");
			manager.persist(newAttachment);
			
			newEmployee.addAttachment(newAttachment);
			manager.persist(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPEmployee cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee cannot find by id : " + newEmployee.getId(), cpEmployee);
		
		assertEquals("Firstname not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
		
		assertEquals("Lastname not equal : " + newEmployee.getLastName() + " == " + cpEmployee.getLastName(), newEmployee.getLastName(), cpEmployee.getLastName());
		
		assertEquals("Gender not equal : " + newEmployee.getGender() + " == " + cpEmployee.getGender(), newEmployee.getGender(), cpEmployee.getGender());
		
		assertEquals("Date not equal : " + newEmployee.getBirthDate() + " == " + cpEmployee.getBirthDate(), newEmployee.getBirthDate(), cpEmployee.getBirthDate());
		
		CPAttachment cpAttachment = manager.find(CPAttachment.class, newAttachment.getId());
		
		assertNotNull("Attachment cannot find by id : " + newAttachment.getId(), cpAttachment);
		
		assertEquals("Type not equal : " + newAttachment.getType() + " == " + cpAttachment.getType(), newAttachment.getType(), cpAttachment.getType());
		
		tx.begin();
		try {
			manager.remove(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		cpAttachment = manager.find(CPAttachment.class, newAttachment.getId());
		
		assertNull("Attachment can find by id : " + newAttachment.getId(), cpAttachment);
	}
	
	@Test
	public void deletePhoneNumber() {
		CPEmployee newEmployee = new CPEmployee();
		CPPhoneNumber newPhoneNumber = new CPPhoneNumber();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newEmployee.setFirstName("john");
			newEmployee.setLastName("smith");
			newEmployee.setGender("male");
			newEmployee.setBirthDate(Calendar.getInstance().getTime());
			
			newPhoneNumber.setPhoneNumber("0607080910");
			manager.persist(newPhoneNumber);
			
			newEmployee.addPhoneNumber(newPhoneNumber);
			manager.persist(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPEmployee cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee cannot find by id : " + newEmployee.getId(), cpEmployee);
		
		assertEquals("Firstname not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
		
		assertEquals("Lastname not equal : " + newEmployee.getLastName() + " == " + cpEmployee.getLastName(), newEmployee.getLastName(), cpEmployee.getLastName());
		
		assertEquals("Gender not equal : " + newEmployee.getGender() + " == " + cpEmployee.getGender(), newEmployee.getGender(), cpEmployee.getGender());
		
		assertEquals("Date not equal : " + newEmployee.getBirthDate() + " == " + cpEmployee.getBirthDate(), newEmployee.getBirthDate(), cpEmployee.getBirthDate());
		
		CPPhoneNumber cpPhoneNumber = manager.find(CPPhoneNumber.class, newPhoneNumber.getId());
		
		assertNotNull("PhoneNumber cannot find by id : " + newPhoneNumber.getId(), cpPhoneNumber);
		
		assertEquals("PhoneNumber not equal : " + newPhoneNumber.getPhoneNumber() + " == " + cpPhoneNumber.getPhoneNumber(), newPhoneNumber.getPhoneNumber(), cpPhoneNumber.getPhoneNumber());
		
		tx.begin();
		try {
			manager.remove(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		cpPhoneNumber = manager.find(CPPhoneNumber.class, newPhoneNumber.getId());
		
		assertNull("PhoneNumber can find by id : " + newPhoneNumber.getId(), cpPhoneNumber);
	}
	
	@Test
	public void deleteAddress() {
		CPEmployee newEmployee = new CPEmployee();
		CPAddress newAddress = new CPAddress();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newEmployee.setFirstName("john");
			newEmployee.setLastName("smith");
			newEmployee.setGender("male");
			newEmployee.setBirthDate(Calendar.getInstance().getTime());
			
			newAddress.setCity("RENNES");
			manager.persist(newAddress);
			
			newEmployee.addAddress(newAddress);
			manager.persist(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPEmployee cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee cannot find by id : " + newEmployee.getId(), cpEmployee);
		
		assertEquals("Firstname not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
		
		assertEquals("Lastname not equal : " + newEmployee.getLastName() + " == " + cpEmployee.getLastName(), newEmployee.getLastName(), cpEmployee.getLastName());
		
		assertEquals("Gender not equal : " + newEmployee.getGender() + " == " + cpEmployee.getGender(), newEmployee.getGender(), cpEmployee.getGender());
		
		assertEquals("Date not equal : " + newEmployee.getBirthDate() + " == " + cpEmployee.getBirthDate(), newEmployee.getBirthDate(), cpEmployee.getBirthDate());
		
		CPAddress cpAddress = manager.find(CPAddress.class, newAddress.getId());
		
		assertNotNull("Address cannot find by id : " + newAddress.getId(), cpAddress);
		
		assertEquals("Address not equal : " + newAddress.getCity() + " == " + cpAddress.getCity(), newAddress.getCity(), cpAddress.getCity());
		
		tx.begin();
		try {
			manager.remove(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		cpAddress = manager.find(CPAddress.class, newAddress.getId());
		
		assertNotNull("Address can't find by id : " + newAddress.getId(), cpAddress);
	}
	
	@Test
	public void deleteEnterprise() {
		CPEmployee newEmployee = new CPEmployee();
		CPEnterprise newEnterprise = new CPEnterprise();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			newEmployee.setFirstName("john");
			newEmployee.setLastName("smith");
			newEmployee.setGender("male");
			newEmployee.setBirthDate(Calendar.getInstance().getTime());
			
			newEnterprise.setLabel("sopragemini");
			manager.persist(newEnterprise);
			
			newEmployee.addEnterprise(newEnterprise);
			manager.persist(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		CPEmployee cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
		
		assertNotNull("Employee cannot find by id : " + newEmployee.getId(), cpEmployee);
		
		assertEquals("Firstname not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
		
		assertEquals("Lastname not equal : " + newEmployee.getLastName() + " == " + cpEmployee.getLastName(), newEmployee.getLastName(), cpEmployee.getLastName());
		
		assertEquals("Gender not equal : " + newEmployee.getGender() + " == " + cpEmployee.getGender(), newEmployee.getGender(), cpEmployee.getGender());
		
		assertEquals("Date not equal : " + newEmployee.getBirthDate() + " == " + cpEmployee.getBirthDate(), newEmployee.getBirthDate(), cpEmployee.getBirthDate());
		
		CPEnterprise cpAddress = manager.find(CPEnterprise.class, newEnterprise.getId());
		
		assertNotNull("Enterprise cannot find by id : " + newEnterprise.getId(), cpAddress);
		
		assertEquals("Enterprise not equal : " + newEnterprise.getLabel() + " == " + cpAddress.getLabel(), newEnterprise.getLabel(), cpAddress.getLabel());
		
		tx.begin();
		try {
			manager.remove(newEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		cpAddress = manager.find(CPEnterprise.class, newEnterprise.getId());
		
		assertNotNull("Enterprise can't find by id : " + newEnterprise.getId(), cpAddress);
	}
}
