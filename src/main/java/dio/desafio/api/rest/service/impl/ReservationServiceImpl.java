package dio.desafio.api.rest.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.desafio.api.rest.domain.model.Reservation;
import dio.desafio.api.rest.domain.repository.ReservationRepository;
import dio.desafio.api.rest.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Reservation create(Reservation reservationToCreate) {
    	if(reservationToCreate.getId() != null && reservationRepository.existsById(reservationToCreate.getId())) {
    		throw new IllegalArgumentException("This Reservation ID already exists;");
    	}
        return reservationRepository.save(reservationToCreate);
    }
    
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
	
}
