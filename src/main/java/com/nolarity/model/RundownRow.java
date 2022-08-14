package com.nolarity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rundown_rows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RundownRow {

	@Id
	@Column(name="row_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rowId;
	
	private String rowType;
	
	private String rowPageNumber;
	
	private String rowSegment;
	
	private long rowStoryId;

	public RundownRow(String rowType, String rowPageNumber, String rowSegment, long rowStoryId) {
		super();
		this.rowType = rowType;
		this.rowPageNumber = rowPageNumber;
		this.rowSegment = rowSegment;
		this.rowStoryId = rowStoryId;
	}
    		
}
