package pro.vinyard.project.entity.peristence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CPPhoneNumber {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String phoneNumber;
	private String phoneType;
	
	public CPPhoneNumber(long id, String phoneNumber, String phoneType) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}
	
	public CPPhoneNumber() {
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
