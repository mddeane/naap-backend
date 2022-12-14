package com.nolarity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolarity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
