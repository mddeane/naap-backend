package com.nolarity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolarity.model.Rundown;
import com.nolarity.model.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer>{

	Story findByStoryId(long storyId);	

}
