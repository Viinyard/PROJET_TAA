package pro.vinyard.project.entity.peristence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CPEnterprise {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String label;
	private long creationDate;
	private long taxYear;
	private String siretNumber;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<CPAttachment> attachments;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<CPAddress> addresses;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<CPPhoneNumber> phoneNumbers;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<CPEmployee> employees;
	
	public CPEnterprise() {
		this.attachments = new ArrayList<>();
		this.addresses = new ArrayList<>();
		this.phoneNumbers = new ArrayList<>();
		this.employees = new ArrayList<>();
	}
	
	public void addAttachment(CPAttachment attachment) {
		this.attachments.add(attachment);
	}
	
	public void addAddress(CPAddress address) {
		this.addresses.add(address);
	}
	
	public void addPhoneNumber(CPPhoneNumber phone) {
		this.phoneNumbers.add(phone);
	}
	
	public void addEmployee(CPEmployee employee) {
		this.employees.add(employee);
	}
	
	public void removeAttachment(CPAttachment attachment) {
		this.attachments.remove(attachment);
	}
	
	public void removeAddress(CPAddress address) {
		this.addresses.remove(address);
	}
	
	public void removePhoneNumber(CPPhoneNumber phone) {
		this.phoneNumbers.remove(phone);
	}
	
	public void removeEmployee(CPEmployee employee) {
		this.employees.remove(employee);
	}
	
	public List<CPAttachment> getAttachments() {
		return this.attachments;
	}
	
	public List<CPAddress> getAddresses() {
		return this.addresses;
	}
	
	public List<CPPhoneNumber> getPhoneNumbers() {
		return this.phoneNumbers;
	}
	
	public List<CPEmployee> getEmployees() {
		return this.employees;
	}
	
	public void addAttachments(List<CPAttachment> attachments) {
		this.attachments.addAll(attachments);
	}
	
	public void addAddresses(List<CPAddress> addresses) {
		this.addresses.addAll(addresses);
	}
	
	public void addPhoneNumbers(List<CPPhoneNumber> phoneNumbers) {
		this.phoneNumbers.addAll(phoneNumbers);
	}
	
	public void addEmployees(List<CPEmployee> employees) {
		this.employees.addAll(employees);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public long getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	
	public long getTaxYear() {
		return taxYear;
	}
	
	public void setTaxYear(long taxYear) {
		this.taxYear = taxYear;
	}
	
	public String getSiretNumber() {
		return siretNumber;
	}
	
	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}
}
