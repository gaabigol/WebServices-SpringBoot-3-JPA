package com.bernardodeveloper.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bernardodeveloper.course.entities.User;
import com.bernardodeveloper.course.repositories.UserRepository;
import com.bernardodeveloper.course.services.exceptions.DataBaseException;
import com.bernardodeveloper.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> userObj = repository.findById(id);
		return userObj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User userObject) {
		return repository.save(userObject);

	}

	public void delete(long id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException error) {
			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException error) {
			throw new DataBaseException(error.getMessage());
		}
	}

	public User update(Long id, User object) {
		try {
			User entity = repository.getReferenceById(id);
			updateDate(entity, object);
			return repository.save(entity);

		} catch (EntityNotFoundException error) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDate(User entity, User object) {
		entity.setName(object.getName());
		entity.setEmail(object.getEmail());
		entity.setPhone(object.getPhone());

	}

}
