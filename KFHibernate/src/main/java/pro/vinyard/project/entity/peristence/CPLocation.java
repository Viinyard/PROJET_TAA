package pro.vinyard.project.entity.peristence;


import com.google.maps.model.LatLng;

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
	
	public CPLocation(LatLng latLng) {
		if(latLng != null) {
			this.lat = latLng.lat;
			this.lng = latLng.lng;
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
