package org.sid.edule.services;

import org.sid.edule.entities.User;

public interface UserService {

	public void addUser(User user);
	public Boolean login(User user);
}
