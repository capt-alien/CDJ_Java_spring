package com.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.models.User;
import com.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
//	REGESTER USER
	public User regesterUser(User user) {
		String hashedPW =BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPW);
		return userRepo.save(user);
	}
	
//	FIND BY EMAIL
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
//	FIND USER BY ID
	public User findUserByID(long id) {
		Optional<User> u = userRepo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else {
			return null;
		}
	}
	
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepo.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

}
