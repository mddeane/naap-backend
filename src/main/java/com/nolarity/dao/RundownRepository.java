package com.nolarity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nolarity.model.Rundown;

@Repository
public interface RundownRepository extends JpaRepository<Rundown, Integer> {

	Rundown findByRundownId(long rundownId);

	@Modifying
	@Query(value = "SELECT * FROM RUNDOWN_ROW_JOIN where RUNDOWN_ROW_JOIN.RUNDOWN_ID = ?", nativeQuery = true)
	List<Long> findStoryIdsByRundown(long rundownId);
}
