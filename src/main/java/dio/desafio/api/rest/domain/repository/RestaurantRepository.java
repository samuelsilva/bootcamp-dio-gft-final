package dio.desafio.api.rest.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import dio.desafio.api.rest.domain.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
