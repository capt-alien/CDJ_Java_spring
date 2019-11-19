package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.models.Show;
import com.repositories.ShowRepo;

@Service
public class ShowService {
	private final ShowRepo showRepo;

	public ShowService(ShowRepo showRepo) {
		super();
		this.showRepo = showRepo;
	}
	
//	CREATE SHOW
	public Show createShow(Show show) {
		return showRepo.save(show);
	}
	
//	update SHOW
	public Show updateShow(Show show) {
		return showRepo.save(show);
	}
	
//	FIND ALL SHOWS
	public List<Show> findall(){
		return showRepo.findAll();
	}
	
//	FIND SHOW BY ID
	public Show findShowById(Long id) {
		Optional<Show> s = showRepo.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
			return null;
		}
	}
//	DELETE
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
	
	

}
