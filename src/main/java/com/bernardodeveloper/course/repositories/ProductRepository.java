package com.bernardodeveloper.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardodeveloper.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

