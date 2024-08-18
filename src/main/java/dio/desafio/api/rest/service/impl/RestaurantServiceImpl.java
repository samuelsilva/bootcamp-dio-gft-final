package dio.desafio.api.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.desafio.api.rest.domain.model.Restaurant;
import dio.desafio.api.rest.domain.repository.RestaurantRepository;
import dio.desafio.api.rest.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

	@Override
	public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
	}

	@Override
	public Restaurant create(Restaurant restaurantToCreate) {
		return restaurantRepository.save(restaurantToCreate);
	}
}

