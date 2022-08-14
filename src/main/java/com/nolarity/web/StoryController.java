package com.nolarity.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nolarity.model.Story;
import com.nolarity.service.StoryService;

@RestController
@RequestMapping("stories")
public class StoryController {
	
	@Autowired
	private StoryService storyServ;
	
	@GetMapping
	public ResponseEntity<Set<Story>> findAll() {
		return ResponseEntity.ok(storyServ.findAll());
	}
	
	
}
