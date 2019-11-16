package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.models.Category;
import com.models.Product;

public interface ProductRepo extends CrudRepository<Product , Long> {
	Optional<Product> findById(Long id);

}
