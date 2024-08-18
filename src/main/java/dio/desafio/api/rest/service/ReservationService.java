package dio.desafio.api.rest.service;

import java.util.List;

import dio.desafio.api.rest.domain.model.Reservation;

public interface ReservationService {

    public List<Reservation> findAll();

    public Reservation findById(Long id);
    
    public Reservation create(Reservation reservationToCreate);

    public void delete(Long id);

	
}
