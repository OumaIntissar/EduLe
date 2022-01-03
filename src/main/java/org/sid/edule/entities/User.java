package org.sid.edule.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class User implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String name;
	private int age;
	private String image;
	private Date joinDate;
	
	@OneToOne
	private Language language;
	
	@OneToOne
	private Country country;
	
	@OneToOne
	private Role role;
	
	@OneToMany (mappedBy = "user")
	private Collection<Comment> comments;

}
