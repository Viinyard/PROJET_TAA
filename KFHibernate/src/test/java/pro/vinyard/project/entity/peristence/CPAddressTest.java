package pro.vinyard.project.entity.peristence;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressType;
import com.google.maps.model.GeocodingResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.debugger.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CPAddressTest {
	
	private final static String API_KEY = "AIzaSyBCV9qcodF69hmqiI4-k74Mw0WEqVVwJFs";
	private EntityManager manager;
	private GeoApiContext context;
	
	@Before
	public void setUp() throws Exception {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("pgsql");
		assertNotNull(factory);
		
		this.context = new GeoApiContext.Builder()
				.apiKey(API_KEY)
				.build();
		
		this.manager = factory.createEntityManager();
		
		assertNotNull(this.manager);
		
	}
	
	@After
	public void tearDown() throws Exception {
		this.manager.close();
		assertFalse(manager.isOpen());
		
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
		
			assertEquals(AddressType.ESTABLISHMENT, results[0].types[0]);
			assertEquals(AddressType.LIBRARY, results[0].types[1]);
			assertEquals(AddressType.POINT_OF_INTEREST, results[0].types[2]);
			assertNotNull(Arrays.toString(results));
			
		} catch (ApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}