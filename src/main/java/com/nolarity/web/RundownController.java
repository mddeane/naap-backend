package com.nolarity.web;

import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nolarity.model.Rundown;
import com.nolarity.model.RundownRow;
import com.nolarity.service.RundownService;

@RestController
@RequestMapping("rundowns")
public class RundownController {

	@Autowired
	private RundownService rundownServ;
	
	@GetMapping
	public ResponseEntity<Set<Rundown>> findAll() {
		return ResponseEntity.ok(rundownServ.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Rundown> addRundown(@Valid @RequestBody Rundown rundown) {
		return ResponseEntity.ok(rundownServ.add(rundown));
	}
	
	@GetMapping("/{rundownId}")
	public ResponseEntity<Rundown> findRundownByRundownId(@PathVariable("rundownId") long rundownId) {
	
		return ResponseEntity.ok(rundownServ.getRundownById(rundownId));
	}

	@PutMapping("/add/{rundownId}")
	public ResponseEntity<Rundown> addRowToRundown(@PathVariable("rundownId") long rundownId, @Valid @RequestBody RundownRow newRow) {
		return ResponseEntity.ok(rundownServ.addRowToRundown(rundownId, newRow));
	}

}
