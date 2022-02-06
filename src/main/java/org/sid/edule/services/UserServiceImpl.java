package org.sid.edule.services;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.sid.edule.dao.UserRepository;
import org.sid.edule.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;

	public String encode(String toEncode) {
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(toEncode.getBytes());
	}

	@Override
	public void addUser(User newUser) {
		newUser.setPassword(encode(newUser.getPassword()));
		userRepo.save(newUser);
	}

	@Override
	public Boolean login(User user) {
		String password = encode(user.getPassword());
		if (!userRepo.findByEmail(user.getEmail()).isEmpty() && !userRepo.findByPassword(password).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
