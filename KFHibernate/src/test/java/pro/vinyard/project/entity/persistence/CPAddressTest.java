package pro.vinyard.project.entity.persistence;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CPAddressTest {
	
	private final static String API_KEY = "AIzaSyBCV9qcodF69hmqiI4-k74Mw0WEqVVwJFs";
	private EntityManagerFactory emf;
	private EntityManager manager;
	private GeoApiContext context;
	
	@Before
	public void setUp() throws Exception {
		this.emf =
				Persistence.createEntityManagerFactory("pgsql");
		assertNotNull(this.emf);
		
		this.context = new GeoApiContext.Builder()
				.apiKey(API_KEY)
				.build();
		
		this.manager = this.emf.createEntityManager();
		
		assertNotNull(this.manager);
		
	}
	
	@After
	public void tearDown() {
		this.manager.close();
		assertFalse(manager.isOpen());
		
		this.emf.close();
		assertFalse(this.emf.isOpen());
		
		this.context.shutdown();
	}
	
	@Test
	public void testGeocodeLibraryType() {
		try {
			List<CPAddress> listAddress = new ArrayList<>();
			GeocodingResult[] results = GeocodingApi.newRequest(this.context).address("ISTIC rennes").await();
			for(GeocodingResult r : results) {
				listAddress.add(new CPAddress(r));
			}
		
			for(CPAddress cpAddress : listAddress) {
				assertNotNull("Address is null", cpAddress);
				if(cpAddress != null) {
					assertNotNull("Address City is null", cpAddress.getCity());
					assertNotNull("Address country is null", cpAddress.getCountry());
					assertNotNull("Address Formatted_Address is null", cpAddress.getFormattedAddress());
					assertNotNull("Address Id is null", cpAddress.getId());
					assertNotNull("Address Location is null", cpAddress.getLocation());
					if(cpAddress.getLocation() != null) {
						assertNotNull("Location ID is null", cpAddress.getLocation().getId());
						assertNotNull("Location Lat is null", cpAddress.getLocation().getLat());
						assertNotNull("Location Lng is null", cpAddress.getLocation().getLng());
					}
					
					assertNotNull("street is null", cpAddress.getStreet());
					assertNotNull("placeId is null", cpAddress.getPlaceId());
				}
			}
			
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}