package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.models.User;
import com.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void addUser(User user) {
		userRepository.save(user);
	}
	public List<User> getAllUsers(){
		return(List<User>) userRepository.findAll();
	}
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	public User getUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			return null;
	}
	}
}
