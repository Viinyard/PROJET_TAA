package pro.vinyard.project.rest.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Employee")
public class CPEmployee {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDate;
	private String licenceNumber;
	private Date licenceDate;
	private String mail;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<CPAttachment> attachments;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<CPPhoneNumber> phoneNumbers;
	
	@OneToMany(cascade = CascadeType.DETACH)
	private List<CPAddress> addresses;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<CPEnterprise> enterprises;
	
	public CPEmployee() {
		this.attachments = new ArrayList<>();
		this.phoneNumbers = new ArrayList<>();
		this.addresses = new ArrayList<>();
		this.enterprises = new ArrayList<>();
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
	
	public void addEnterprise(CPEnterprise enterprise) {
		this.enterprises.add(enterprise);
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
	
	public void removeEnterprise(CPEnterprise enterprise) {
		this.enterprises.add(enterprise);
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
	
	public List<CPEnterprise> getEnterprises() {
		return this.enterprises;
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
	
	public void addEnterprises(List<CPEnterprise> enterprises) {
		this.enterprises.addAll(enterprises);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getLicenceNumber() {
		return licenceNumber;
	}
	
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	
	public Date getLicenceDate() {
		return licenceDate;
	}
	
	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
}