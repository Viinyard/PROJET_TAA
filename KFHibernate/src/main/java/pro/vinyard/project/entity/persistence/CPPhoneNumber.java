package pro.vinyard.project.entity.persistence;

import javax.persistence.*;

@Entity
@Table(name="PhoneNumber")
public class CPPhoneNumber {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String phoneNumber;
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
