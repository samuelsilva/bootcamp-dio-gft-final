package dio.desafio.api.rest.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.desafio.api.rest.domain.model.Restaurant;
import dio.desafio.api.rest.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	private final RestaurantService restaurantService;
	
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable("id") Long id){
		var user = restaurantService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurantToCreate){
		var restaurantCreated = restaurantService.create(restaurantToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(restaurantCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(restaurantCreated);
	}	

}
