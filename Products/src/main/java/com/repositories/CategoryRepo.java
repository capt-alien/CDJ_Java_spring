package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

}
