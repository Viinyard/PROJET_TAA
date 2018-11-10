package pro.vinyard.project.rest.data;


import com.google.maps.model.LatLng;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class CPLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lng")
	private double lng;
	
	public CPLocation(LatLng latLng) {
		if(latLng != null) {
			this.lat = latLng.lat;
			this.lng = latLng.lng;
		}
	}
	
	public CPLocation() {
		// default constructor
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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
