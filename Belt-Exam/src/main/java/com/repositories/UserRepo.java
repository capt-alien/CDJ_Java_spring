package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	User findByEmail(String eamil);

}
