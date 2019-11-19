package com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.models.Show;

public interface ShowRepo extends CrudRepository<Show, Long> {
	List<Show> findAll();
}
