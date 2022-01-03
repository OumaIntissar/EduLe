package org.sid.edule.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Course implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int nbSection;
	private Boolean hasCertificate;
	private int nbEnrolledStud;
	private int nbReview;
	
	@OneToOne 
	private Description description;
	
	@OneToMany(mappedBy = "course")
	private Collection<Section> sections;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Instructor instructor;
	
	
}
