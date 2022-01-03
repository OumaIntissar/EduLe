package org.sid.edule.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Section implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int nbLecture;
	private Time totalDuration;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Course course;
	
	@OneToMany (mappedBy = "section")
	private Collection<Lecture> lectures;
}
