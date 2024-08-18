package dio.desafio.api.rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dio.desafio.api.rest.domain.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
