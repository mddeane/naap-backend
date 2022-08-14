package com.nolarity.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nolarity.model.RundownRow;

@Repository
public interface RundownRowRepository extends JpaRepository<RundownRow, Integer> {


}
