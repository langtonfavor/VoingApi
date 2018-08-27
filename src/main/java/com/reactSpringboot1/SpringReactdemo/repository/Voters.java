package com.reactSpringboot1.SpringReactdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reactSpringboot1.SpringReactdemo.modal.Vote;

public interface Voters extends JpaRepository<Vote, Long> {

	Optional<Vote>findById(Long voteId);
	
	Page<Vote>findByCreatedBy(Long userId, Pageable pageable);
	
	//Long countedBy(Long userId);
	
	 long countByCreatedBy(Long userId);
	 
    List<Vote> findByIdIn(List<Long> pollIds);

    List<Vote> findByIdIn(List<Long> pollIds, Sort sort);
}

