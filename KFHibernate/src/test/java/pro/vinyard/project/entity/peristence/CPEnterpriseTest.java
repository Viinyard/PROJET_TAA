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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author VinYarD
 * created : 12/10/2018, 20:08
 */


public class CPEnterpriseTest {
		
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
			CPEnterprise newEnterprise = new CPEnterprise();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				newEnterprise.setCreationDate(Calendar.getInstance().getTime());
				newEnterprise.setLabel("Enterprise Test");
				newEnterprise.setTaxYear(2018);
				newEnterprise.setSiretNumber("1234567890");
				manager.persist(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			CPEnterprise cpEnterprise = manager.find(CPEnterprise.class, newEnterprise.getId());
			
			assertNotNull("Enterprise cannot find by id : " + newEnterprise.getId(), cpEnterprise);
			
			assertEquals("Label not equal : " + newEnterprise.getLabel() + " == " + cpEnterprise.getLabel(), newEnterprise.getLabel(), newEnterprise.getLabel());
			
			assertTrue("Siret Number not equal : " + newEnterprise.getSiretNumber() + " == " + cpEnterprise.getSiretNumber(), newEnterprise.getSiretNumber().equals(cpEnterprise.getSiretNumber()));
			
			assertTrue("Creation date not equal : " + newEnterprise.getCreationDate() + " == " + cpEnterprise.getCreationDate(), newEnterprise.getCreationDate().compareTo(cpEnterprise.getCreationDate()) == 0);
			
			assertEquals("TaxYear not equal : " + newEnterprise.getTaxYear() + " == " + cpEnterprise.getTaxYear(), newEnterprise.getTaxYear(), cpEnterprise.getTaxYear());
		}
		
		@Test
		public void deleteAttachment() {
			CPEnterprise newEnterprise = new CPEnterprise();
			CPAttachment newAttachment = new CPAttachment();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				newEnterprise.setCreationDate(Calendar.getInstance().getTime());
				newEnterprise.setLabel("Enterprise Test");
				newEnterprise.setTaxYear(2018);
				newEnterprise.setSiretNumber("1234567890");
				manager.persist(newEnterprise);
				
				newAttachment.setType("file");
				manager.persist(newAttachment);
				
				newEnterprise.addAttachment(newAttachment);
				manager.persist(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			CPEnterprise cpEnterprise = manager.find(CPEnterprise.class, newEnterprise.getId());
			
			assertNotNull("Enterprise cannot find by id : " + newEnterprise.getId(), cpEnterprise);
			
			assertEquals("Label not equal : " + newEnterprise.getLabel() + " == " + cpEnterprise.getLabel(), newEnterprise.getLabel(), newEnterprise.getLabel());
			
			assertTrue("Siret Number not equal : " + newEnterprise.getSiretNumber() + " == " + cpEnterprise.getSiretNumber(), newEnterprise.getSiretNumber().equals(cpEnterprise.getSiretNumber()));
			
			assertTrue("Creation date not equal : " + newEnterprise.getCreationDate() + " == " + cpEnterprise.getCreationDate(), newEnterprise.getCreationDate().compareTo(cpEnterprise.getCreationDate()) == 0);
			
			assertEquals("TaxYear not equal : " + newEnterprise.getTaxYear() + " == " + cpEnterprise.getTaxYear(), newEnterprise.getTaxYear(), cpEnterprise.getTaxYear());
			
			assertTrue("ListAttachment size", cpEnterprise.getAttachments().size() == 1);
			
			CPAttachment cpAttachment = manager.find(CPAttachment.class, cpEnterprise.getAttachments().get(0).getId());
			
			assertNotNull("Attachment cannot find by id : " + newAttachment.getId(), cpAttachment);
			
			assertEquals("Type not equal : " + newAttachment.getType() + " == " + cpAttachment.getType(), newAttachment.getType(), cpAttachment.getType());
			
			//newEnterprise.removeAttachment(cpAttachment);
			
			//assertTrue("AddressList empty", newEnterprise.getAttachments().isEmpty());
			
			//assertNull("find Address", manager.find(CPAddress.class, cpAttachment.getId()));
			
			tx.begin();
			try {
				manager.remove(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			cpAttachment = manager.find(CPAttachment.class, newAttachment.getId());
			
			//assertNull("Attachment can find by id : " + newAttachment.getId(), newAttachment.getId());
		}
		
		@Test
		public void deletePhoneNumber() {
			CPEnterprise newEnterprise = new CPEnterprise();
			CPPhoneNumber newPhoneNumber = new CPPhoneNumber();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				newEnterprise.setCreationDate(Calendar.getInstance().getTime());
				newEnterprise.setLabel("Enterprise Test");
				newEnterprise.setTaxYear(2018);
				newEnterprise.setSiretNumber("1234567890");
				manager.persist(newEnterprise);
				
				newPhoneNumber.setPhoneNumber("0607080910");
				manager.persist(newPhoneNumber);
				
				newEnterprise.addPhoneNumber(newPhoneNumber);
				manager.persist(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			CPEnterprise cpEnterprise = manager.find(CPEnterprise.class, newEnterprise.getId());
			
			assertNotNull("Enterprise cannot find by id : " + newEnterprise.getId(), cpEnterprise);
			
			assertEquals("Label not equal : " + newEnterprise.getLabel() + " == " + cpEnterprise.getLabel(), newEnterprise.getLabel(), newEnterprise.getLabel());
			
			assertTrue("Siret Number not equal : " + newEnterprise.getSiretNumber() + " == " + cpEnterprise.getSiretNumber(), newEnterprise.getSiretNumber().equals(cpEnterprise.getSiretNumber()));
			
			assertTrue("Creation date not equal : " + newEnterprise.getCreationDate() + " == " + cpEnterprise.getCreationDate(), newEnterprise.getCreationDate().compareTo(cpEnterprise.getCreationDate()) == 0);
			
			assertEquals("TaxYear not equal : " + newEnterprise.getTaxYear() + " == " + cpEnterprise.getTaxYear(), newEnterprise.getTaxYear(), cpEnterprise.getTaxYear());
			
			assertTrue("Phone number list size", cpEnterprise.getPhoneNumbers().size() == 1);
			
			CPPhoneNumber cpPhoneNumber = manager.find(CPPhoneNumber.class, newEnterprise.getPhoneNumbers().get(0).getId());
			
			assertNotNull("PhoneNumber cannot find by id : " + newPhoneNumber.getId(), cpPhoneNumber);
			
			assertEquals("PhoneNumber not equal : " + newPhoneNumber.getPhoneNumber() + " == " + cpPhoneNumber.getPhoneNumber(), newPhoneNumber.getPhoneNumber(), cpPhoneNumber.getPhoneNumber());
			
			//newEnterprise.removePhoneNumber(cpPhoneNumber);
			
			//assertTrue("AddressList empty", newEnterprise.getPhoneNumbers().isEmpty());
			
			//assertNotNull("find Address", manager.find(CPAddress.class, cpPhoneNumber.getId()));
			
			tx.begin();
			try {
				manager.remove(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			cpPhoneNumber = manager.find(CPPhoneNumber.class, newPhoneNumber.getId());
			
			assertNull("PhoneNumber can find by id : " + newPhoneNumber.getId(), cpPhoneNumber);
		}
		
		@Test
		public void deleteAddress() {
			CPEnterprise newEnterprise = new CPEnterprise();
			CPAddress newAddress = new CPAddress();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				newEnterprise.setCreationDate(Calendar.getInstance().getTime());
				newEnterprise.setLabel("Enterprise Test");
				newEnterprise.setTaxYear(2018);
				newEnterprise.setSiretNumber("1234567890");
				
				newAddress.setCity("RENNES");
				manager.persist(newAddress);
				
				newEnterprise.addAddress(newAddress);
				manager.persist(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			CPEnterprise cpEnterprise = manager.find(CPEnterprise.class, newEnterprise.getId());
			
			assertNotNull("Enterprise cannot find by id : " + newEnterprise.getId(), cpEnterprise);
			
			assertTrue("AddressList size", cpEnterprise.getAddresses().size() == 1);
			
			CPAddress cpAddress = manager.find(CPAddress.class, cpEnterprise.getAddresses().get(0).getId());
			
			assertNotNull("Address cannot find by id : " + newAddress.getId(), cpAddress);
			
			assertEquals("Address not equal : " + newAddress.getCity() + " == " + cpAddress.getCity(), newAddress.getCity(), cpAddress.getCity());
			
			newEnterprise.removeAddress(cpAddress);
			
			assertTrue("AddressList empty", newEnterprise.getAddresses().isEmpty());
			
			assertNotNull("find Address", manager.find(CPAddress.class, cpAddress.getId()));
			
			
			tx.begin();
			try {
				manager.remove(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			cpAddress = manager.find(CPAddress.class, newAddress.getId());
			
			assertNotNull("Address can't find by id : " + newAddress.getId(), cpAddress);
		}
		
		@Test
		public void deleteEmployee() {
			CPEnterprise newEnterprise = new CPEnterprise();
			CPEmployee newEmployee = new CPEmployee();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				newEnterprise.setCreationDate(Calendar.getInstance().getTime());
				newEnterprise.setLabel("Enterprise Test");
				newEnterprise.setTaxYear(2018);
				newEnterprise.setSiretNumber("1234567890");
				manager.persist(newEnterprise);
				
				newEmployee.setFirstName("john");
				newEmployee.setLastName("smith");
				newEmployee.setGender("male");
				newEmployee.setBirthDate(Calendar.getInstance().getTime());
				manager.persist(newEmployee);
				
				newEnterprise.addEmployee(newEmployee);
				manager.persist(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			CPEnterprise cpEnterprise = manager.find(CPEnterprise.class, newEnterprise.getId());
			
			assertNotNull("Enterprise cannot find by id : " + cpEnterprise.getId());
			
			assertTrue("EmployeeList size", cpEnterprise.getEmployees().size() == 1);
			
			CPEmployee cpEmployee = manager.find(CPEmployee.class, cpEnterprise.getEmployees().get(0).getId());
			
			assertNotNull("Employee cannot find by id : " + newEmployee.getId(), cpEmployee);
			
			assertEquals("Employee not equal : " + newEmployee.getFirstName() + " == " + cpEmployee.getFirstName(), newEmployee.getFirstName(), cpEmployee.getFirstName());
			
			//newEnterprise.removeEmployee(cpEmployee);
			
			//assertTrue("AddressList empty", newEnterprise.getEmployees().isEmpty());
			
			//assertNotNull("find Address", manager.find(CPAddress.class, cpEmployee.getId()));
			
			tx.begin();
			try {
				manager.remove(newEnterprise);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			
			cpEmployee = manager.find(CPEmployee.class, newEmployee.getId());
			
			assertNotNull("Enterprise can't find by id : " + newEmployee.getId(), cpEmployee);
		}

}
