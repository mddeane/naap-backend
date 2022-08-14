package com.nolarity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.dao.GraphicRepository;
import com.nolarity.model.Graphic;

@Service
public class GraphicService {

	@Autowired
	private GraphicRepository graphicRepo;
	
	@Transactional(readOnly=true)
	public Set<Graphic> findAll() {
		return graphicRepo.findAll().stream().collect(Collectors.toSet());
	}
	
}
