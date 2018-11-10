package pro.vinyard.project.rest.data;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car")
public class CPCar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "fiscal_horsepower")
	private int fiscalHorsepower;
	
	@Column(name = "registration_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date registrationDate;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "employee_id")
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
