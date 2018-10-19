package pro.vinyard.project.entity.persistence;

import javax.persistence.*;

/**
 * @author VinYarD
 * created : 14/09/2018, 09:43
 */

@Entity
public class CPDeplacement {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private CPCar car;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private CPEmployee employee;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private CPAddress addressDepart;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private CPAddress addressArrivee;
	
	public CPDeplacement() {
		// default constructor
	}
	
	public long getID() {
		return id;
	}
	
	public void setID(long id) {
		this.id = id;
	}
	
	public CPCar getCar() {
		return car;
	}
	
	public void setCar(CPCar car) {
		this.car = car;
	}
	
	public CPEmployee getEmployee() {
		return employee;
	}
	
	public void setEmployee(CPEmployee employee) {
		this.employee = employee;
	}
	
	public CPAddress getAddressDepart() {
		return addressDepart;
	}
	
	public void setAddressDepart(CPAddress address) {
		this.addressDepart = address;
	}
	
	public CPAddress getAddressArrivee() {
		return addressArrivee;
	}
	
	public void setAddressArrivee(CPAddress address) {
		this.addressArrivee = address;
	}
}
