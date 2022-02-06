package org.sid.edule.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

//@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Setter
@Getter
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;

	@Column(columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP")
	@Generated(GenerationTime.INSERT)
	private LocalDateTime joinDate;

	@OneToMany(mappedBy = "user")
	// @Column(nullable = true)
	// Default system language
	private Collection<Language> language;

	@OneToOne
	private Country country;

	@ManyToMany(mappedBy = "user")
	private Collection<Role> role;

	// Nullable
	@OneToMany(mappedBy = "user")
	private Collection<Comment> comments;
	
	@OneToMany(mappedBy = "user")
	private Collection<Course> Enrolledcourses;
	
	@OneToMany(mappedBy = "user")
	private Collection<Course> Createdcourses;

	private int age;
	private String image;
	private int nbCreated;
	private int nbCourseEnrolled;
	private String specialisation;


}
