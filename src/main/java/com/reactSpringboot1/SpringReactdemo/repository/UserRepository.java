package com.reactSpringboot1.SpringReactdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import antlr.collections.List;

import com.reactSpringboot1.SpringReactdemo.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

   // List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
   // Optional<User> Save(String user);
}

