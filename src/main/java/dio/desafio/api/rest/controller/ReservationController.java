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

import dio.desafio.api.rest.domain.model.Reservation;
import dio.desafio.api.rest.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Reservation> findById(@PathVariable("id") Long id){
		var reservation = reservationService.findById(id);
		return ResponseEntity.ok(reservation);
	}
	
	@PostMapping
	public ResponseEntity<Reservation> create(@RequestBody Reservation reservationToCreate){
		var reservationCreated = reservationService.create(reservationToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(reservationCreated.getId())
				.toUri();
		return ResponseEntity.created(location).body(reservationCreated);
	}	
	
	
}
