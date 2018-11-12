package pro.vinyard.project.rest.controller;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResponse;
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
public class GoogleMapAutocompleteController {
	
	@Value("${google.map.api.key}")
	private String API_KEY;
	
	@RequestMapping("/queryAutocomplete")
	public ResponseEntity<AutocompletePrediction[]> greeting(@RequestParam(required = true, value="address") String address, @RequestParam(value="lat", defaultValue = "49.141881") double lat, @RequestParam(value="lng", defaultValue = "-0.332085") double lng) {
		
		LatLng location = new LatLng(lat, lng);
		GeoApiContext context = new GeoApiContext.Builder()
				.apiKey(API_KEY)
				.build();
		
		try {
			return new ResponseEntity<>(PlacesApi.queryAutocomplete(context, address)
					.location(location)
					.radius(5000)
					.language("fr")
					.await(), HttpStatus.OK);
		} catch (ApiException | InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.noContent().build();
	}
}
