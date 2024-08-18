package dio.desafio.api.rest.service;

import dio.desafio.api.rest.domain.model.Restaurant;


public interface RestaurantService {

	Restaurant findById(Long id);

	Restaurant create(Restaurant restaurantToCreate);
}


