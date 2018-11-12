package pro.vinyard.project.rest.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author VinYarD
 * created : 10/11/2018, 18:36
 */

@PropertySource("classpath:config.properties")
@RestController
public class GoogleMapQueryAddressController {
	
	@Value("${google.map.api.key}")
	private String API_KEY;
	
	@RequestMapping("/queryPlaceDetail")
	public ResponseEntity<PlaceDetails> greeting(@RequestParam(value="place_id") String placeId) {
		GeoApiContext context = new GeoApiContext.Builder()
				.apiKey(API_KEY)
				.build();
		
		try {
			System.out.println(placeId);
			return new ResponseEntity<>(PlacesApi.placeDetails(context, placeId)
					.language("fr")
					.await(), HttpStatus.OK);
		} catch (ApiException | InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
		
		return ResponseEntity.noContent().build();
	}
}
