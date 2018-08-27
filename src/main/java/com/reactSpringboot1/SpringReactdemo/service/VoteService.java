package com.reactSpringboot1.SpringReactdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactSpringboot1.SpringReactdemo.repository.UserRepository;
import com.reactSpringboot1.SpringReactdemo.repository.VoterRollRepository;
import com.reactSpringboot1.SpringReactdemo.repository.Voters;

@Service
public class VoteService {

	@Autowired
	VoterRollRepository voteRepository;
	
	@Autowired
	Voters repository;
	
	@Autowired
	UserRepository userRepository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(VoteService.class);	

	
}
