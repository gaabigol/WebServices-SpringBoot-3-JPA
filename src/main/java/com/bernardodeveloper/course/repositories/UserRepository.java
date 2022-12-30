package com.bernardodeveloper.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardodeveloper.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
