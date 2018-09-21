package pro.vinyard.project.entity.peristence;

import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VinYarD
 * created : 12/09/2018, 17:59
 */

@Entity
public class CPAddress {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String label;
	private String streetNumber;
	private String street;
	private int zipCode;
	private String city;
	private String country;
	private String state;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CPLocation location;
	private String url;
	private String formattedAddress;
	private String placeId;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<CPAttachment> attachments;
	
	public CPAddress() {
		this.attachments = new ArrayList<>();
	}
	
	public CPAddress(GeocodingResult result) {
		this.placeId = result.placeId;
		this.formattedAddress = result.formattedAddress;
		this.location = new CPLocation(result.geometry.location);
		for (AddressComponent addrCpt : result.addressComponents) {
			if (addrCpt.types[0].compareTo(AddressComponentType.STREET_NUMBER) == 0) {
				this.streetNumber = addrCpt.longName;
			} else if (addrCpt.types[0].equals(AddressComponentType.ROUTE)) {
				this.street = addrCpt.longName;
			} else if (addrCpt.types[0].equals(AddressComponentType.POSTAL_CODE)) {
				this.zipCode = Integer.parseInt(addrCpt.longName);
			} else if (addrCpt.types[0].equals(AddressComponentType.LOCALITY)) {
				this.city = addrCpt.longName;
			} else if (addrCpt.types[0].equals(AddressComponentType.COUNTRY)) {
				this.country = addrCpt.longName;
			} else if (addrCpt.types[0].equals(AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1)) {
				this.state = addrCpt.longName;
			}
		}
	}
	
	@Override
	public String toString() {
		String labStr = "";
		if (this.label != null) {
			labStr = this.label + ", ";
		}
		
		String streetStr = "";
		if (this.streetNumber != null && this.streetNumber.length() > 0) {
			streetStr = this.streetNumber + " ";
		}
		
		return labStr + streetStr + this.street + ", " + this.zipCode + " " + this.city + ", " + this.country;
	}
	
	public void addAttachment(CPAttachment attachment) {
		this.attachments.add(attachment);
	}
	
	public void removeAttachment(CPAttachment attachment) {
		this.attachments.remove(attachment);
	}
	
	public void removeAllAttachment() {
		this.attachments.clear();
	}
	
	public List<CPAttachment> getAttachments() {
		return this.attachments;
	}
	
	public void addAttachments(List<CPAttachment> attachments) {
		this.attachments.addAll(attachments);
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public CPLocation getLocation() {
		return this.location;
	}
	
	public void setLocation(CPLocation location) {
		this.location = location;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getFormattedAddress() {
		return formattedAddress;
	}
	
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	
	public String getPlaceId() {
		return placeId;
	}
	
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
}