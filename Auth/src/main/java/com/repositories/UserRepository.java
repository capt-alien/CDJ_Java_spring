package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String eamil);

}
