package br.dev.ferreiras.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.ferreiras.mongo.domain.User;
import br.dev.ferreiras.mongo.dto.UserDTO;
import br.dev.ferreiras.mongo.repository.UserRepository;
import br.dev.ferreiras.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public Optional<User> findById(String id) {

		Optional<User> user = userRepository.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Object Not Found!");
		}

		return user;

	}

	public User insert(User user) {

		return userRepository.insert(user);

	}

	public void delete(String id) {

		findById(id);
		userRepository.deleteById(id);

	}

	public User fromDTO(UserDTO userDTO) {

		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
