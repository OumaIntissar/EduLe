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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Lecture implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String video;
	private Time duration;
	
	@ManyToOne 
	private Section section;
	
	@OneToMany (mappedBy = "lecture")
	private Collection<Comment> comments;
	
}
