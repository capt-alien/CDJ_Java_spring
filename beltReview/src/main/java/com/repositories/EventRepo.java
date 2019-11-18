package com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.models.Event;

public interface EventRepo extends CrudRepository<Event, Long> {
	public List<Event> findByState(String state);

}


