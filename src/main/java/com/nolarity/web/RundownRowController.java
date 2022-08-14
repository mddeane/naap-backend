package com.nolarity.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nolarity.model.RundownRow;
import com.nolarity.service.RundownRowService;

@RestController
@RequestMapping("rows")
public class RundownRowController {

	@Autowired
	private RundownRowService rowServ;
	
	@GetMapping
	public ResponseEntity<Set<RundownRow>> findAll() {
		return ResponseEntity.ok(rowServ.findAll());
	}
		
}
