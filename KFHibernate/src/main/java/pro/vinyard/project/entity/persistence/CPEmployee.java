package pro.vinyard.project.entity.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class CPEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "licence_number")
	private String licenceNumber;
	
	@Column(name = "licence_date")
	private Date licenceDate;
	
	@Column(name = "mail")
	private String mail;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "employee_id")
	private List<CPAttachment> attachments;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "employee_id")
	private List<CPPhoneNumber> phoneNumbers;
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "employee_id")
	private List<CPAddress> addresses;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "employee_enterprise",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name = "enterprise_id")
	)
	private List<CPEnterprise> enterprises;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private List<CPCar> cars;
	
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
	
	public List<CPCar> getCars() {
		return cars;
	}
	
	public void setCars(List<CPCar> cars) {
		this.cars = cars;
	}
}