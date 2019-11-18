package com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.models.Event;
import com.repositories.EventRepo;

@Service
public class EventService {
	private final EventRepo eventRepo;

	public EventService(EventRepo eventRepo) {
		super();
		this.eventRepo = eventRepo;
	}
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	public Event updateEvent(Event event) {
		return eventRepo.save(event);
	}
	public List<Event> findAllEvents(){
		return (List<Event>) eventRepo.findAll();
	}
	public List<Event> findEventByState(String state){
		return eventRepo.findByState(state);
	}
	
	
	
	
	
//	END EVENT Service
}
