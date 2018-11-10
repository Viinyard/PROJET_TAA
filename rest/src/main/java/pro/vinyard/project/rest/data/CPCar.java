package pro.vinyard.project.rest.data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Car")
public class CPCar {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String model;
	private int fiscalHorsepower;
	private Date registrationDate;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private CPEmployee employee;
	
	public CPCar() {
		// default constructor
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getFiscalHorsepower() {
		return fiscalHorsepower;
	}
	
	public void setFiscalHorsepower(int fiscalHorsepower) {
		this.fiscalHorsepower = fiscalHorsepower;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public CPEmployee getEmployee() {
		return employee;
	}
	
	public void setEmployee(CPEmployee idEmployee) {
		this.employee = idEmployee;
	}
}
