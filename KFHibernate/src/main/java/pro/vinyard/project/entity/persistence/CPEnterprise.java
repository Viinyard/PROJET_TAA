package pro.vinyard.project.entity.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author VinYarD
 * created : 08/11/2018, 12:16
 */


@Entity
@Table(name = "enterprise")
public class CPEnterprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "tax_year")
	private int taxYear;
	
	@Column(name = "siret_number")
	private String siretNumber;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "enterprise_id")
	private List<CPAttachment> attachments;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "enterprise_id")
	private List<CPAddress> addresses;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "enterprise_id")
	private List<CPPhoneNumber> phoneNumbers;
	
	@ManyToMany(mappedBy = "enterprises")
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
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public int getTaxYear() {
		return taxYear;
	}
	
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	
	public String getSiretNumber() {
		return siretNumber;
	}
	
	public void setSiretNumber(String siretNumber) {
		this.siretNumber = siretNumber;
	}
}
