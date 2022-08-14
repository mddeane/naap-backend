package com.nolarity.web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nolarity.model.Graphic;
import com.nolarity.service.GraphicService;

@RestController
@RequestMapping("graphics")
public class GraphicController {

	@Autowired
	private GraphicService graphicServ;
	
	@GetMapping
	public ResponseEntity<Set<Graphic>> findAll() {
		return ResponseEntity.ok(graphicServ.findAll());
	}
}
