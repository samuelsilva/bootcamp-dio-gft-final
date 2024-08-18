package dio.desafio.api.rest.service;

import java.util.List;

import dio.desafio.api.rest.domain.model.User;

public interface UserService {
	
	List<User> findAll();
	
	User findById(Long id);
	
	User create(User userToCreate);
}
