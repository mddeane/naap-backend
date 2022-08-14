package com.nolarity.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Story {

	@Id
	@Column(name = "story_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storyId;

	private String state;

	private String title;
	
	private String script;
	
	private long estTime;
	
	@OneToMany
	@JoinTable(name="story_graphic_join", 
	joinColumns = @JoinColumn(name = "story_id"), 
	inverseJoinColumns=@JoinColumn(name = "graphic_id")) 
	private Set<Graphic> graphics;

	public Story(String state, String title, String script, long estTIme) {
		super();
		this.state = state;
		this.title = title;
		this.script = script;
		this.estTime = estTIme;
	}
	
	

}
