package pro.vinyard.project.entity.persistence;

import javax.persistence.*;

/**
 * @author VinYarD
 * created : 14/09/2018, 09:43
 */

@Entity
@Table(name = "deplacement")
public class CPDeplacement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "car_id")
	private CPCar car;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "employee_id")
	private CPEmployee employee;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "address_depart_id")
	private CPAddress addressDepart;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "address_arrivee_id")
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
