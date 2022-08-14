package com.nolarity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.dao.GraphicRepository;
import com.nolarity.dao.StoryRepository;
import com.nolarity.model.Story;

@Service
public class StoryService {

	@Autowired
	private StoryRepository storyRepo;
	
	@Autowired
	private GraphicRepository graphicRepo;

	@Transactional(readOnly = true)
	public Set<Story> findAll() {
		return storyRepo.findAll()
				.stream().collect(Collectors.toSet());
	}

}
