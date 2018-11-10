package pro.vinyard.project.entity.persistence;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class CPPhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "phone_type")
	private String phoneType;
	
	public CPPhoneNumber() {
		// default constructor
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneType() {
		return phoneType;
	}
	
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
}
