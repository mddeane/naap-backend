package com.nolarity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="graphics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graphic {
	
	@Id
	@Column(name="graphic_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String graphicType;
	private String mainLine;
	private String secondLine;
	
	public Graphic(String graphicType, String mainLine, String secondLine) {
		super();
		this.graphicType = graphicType;
		this.mainLine = mainLine;
		this.secondLine = secondLine;
	}
}
