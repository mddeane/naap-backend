package com.nolarity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.dao.RundownRowRepository;
import com.nolarity.model.RundownRow;

@Service
public class RundownRowService {

	@Autowired
	private RundownRowRepository rowRepo;
	
	@Transactional(readOnly = true)
	public Set<RundownRow> findAll() {
		return rowRepo.findAll().stream().collect(Collectors.toSet());
	}
	
}
