package com.nolarity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolarity.model.Graphic;

@Repository
public interface GraphicRepository extends JpaRepository<Graphic, Integer>{

}
