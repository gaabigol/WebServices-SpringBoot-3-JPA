package com.bernardodeveloper.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardodeveloper.course.entities.User;
import com.bernardodeveloper.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> userObj = repository.findById(id);
		return userObj.get();
	}

	public User insert(User userObject) {
		return repository.save(userObject);

	}
	
	public void delete(long id) {
		repository.deleteById(id);
	}

}
