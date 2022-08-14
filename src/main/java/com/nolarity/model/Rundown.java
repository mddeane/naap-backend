package com.nolarity.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rundowns")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rundown {

	@Id
	@Column(name="rundown_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rundownId;

	private String rundownTitle;
	
	private String rundownTemplate;
	
	private String rundownState;
	
	private Date rundownDate;
	
	private long rundownStartTime;
	
	private long rundownEndTime;
	
	@OneToMany
	@JoinTable(name="rundown_row_join", 
	joinColumns = @JoinColumn(name = "rundown_id"), 
	inverseJoinColumns=@JoinColumn(name = "row_id")) 
	private Set<RundownRow> rundownRows;

	public Rundown(String rundownTitle, String rundownTemplate, String rundownState, Date rundownDate,
			long rundownStartTime, long rundownEndTime) {
		super();
		this.rundownTitle = rundownTitle;
		this.rundownTemplate = rundownTemplate;
		this.rundownState = rundownState;
		this.rundownDate = rundownDate;
		this.rundownStartTime = rundownStartTime;
		this.rundownEndTime = rundownEndTime;
	}
	
	

}
