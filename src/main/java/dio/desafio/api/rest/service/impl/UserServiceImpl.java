package dio.desafio.api.rest.service.impl;

import dio.desafio.api.rest.domain.model.User;
import dio.desafio.api.rest.domain.repository.UserRepository;
import dio.desafio.api.rest.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This User ID already exists;");
		}
		// TODO Auto-generated method stub
		return this.userRepository.save(userToCreate);
	}


}
