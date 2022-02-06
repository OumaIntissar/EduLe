package org.sid.edule.dao;

import java.util.List;

import org.sid.edule.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByEmail(String email);
	public List<User> findByPassword(String password);

}
