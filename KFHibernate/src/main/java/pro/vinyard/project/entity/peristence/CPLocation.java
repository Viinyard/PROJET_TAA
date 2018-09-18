package pro.vinyard.project.entity.peristence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CPLocation {
	
	@Id
	@GeneratedValue
	private String id;
	
	private double lat;
	
	private double lng;
	
	public CPLocation(String latLng) {
		super();
		String[] tmp = latLng.split(",");
		if (tmp.length == 2) {
			this.setLat(Double.parseDouble(tmp[0]));
			this.setLng(Double.parseDouble(tmp[1]));
		}
		
		if (tmp.length != 2 || !latLng.equals(this.toString())) {
			System.out.println("Wrong LatLng String input");
		}
	}
	
	public CPLocation() {
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public String toString() {
		return this.lat + "," + this.lng;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
