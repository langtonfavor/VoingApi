package com.reactSpringboot1.SpringReactdemo.voteController;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reactSpringboot1.SpringReactdemo.authenticity.ApiResponse;
import com.reactSpringboot1.SpringReactdemo.modal.Vote;
import com.reactSpringboot1.SpringReactdemo.payLoads.PagedResponse;
import com.reactSpringboot1.SpringReactdemo.payLoads.VoteResponse;
import com.reactSpringboot1.SpringReactdemo.payLoads.VoteRollRequest;
import com.reactSpringboot1.SpringReactdemo.repository.UserRepository;
import com.reactSpringboot1.SpringReactdemo.repository.VoterRollRepository;
import com.reactSpringboot1.SpringReactdemo.repository.Voters;
import com.reactSpringboot1.SpringReactdemo.security.CurrentUser;
import com.reactSpringboot1.SpringReactdemo.security.UserPrincipal;
import com.reactSpringboot1.SpringReactdemo.service.VoteService;
import com.reactSpringboot1.SpringReactdemo.utils.AppConstants;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

        @Autowired
	    private Voters votersRepository;

	    @Autowired
	    private VoterRollRepository voteRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private VoteService pollService;
	    
	    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);
	    
	    public PagedResponse<VoteResponse>getVotes(@CurrentUser UserPrincipal currentUser,
	    											@RequestParam(value = "page", defaultValue= AppConstants.DEFAULT_PAGE_NUMBER) int page,
	    											@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE)int size) {
	    	
	    											return pollService.getAllPolls(currentUser, page, size);										
	    }
	    @PostMapping
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?>createVote(@Valid @RequestBody VoteRollRequest voteRequest) {
	    	
	    	Vote vote=voteService.createVote(voteRequest);
	    	
	    	URI location = ServletUriComponentsBuilder
	    					.fromCurrentRequest().path("{/voteId}")
	    					.buildAndExpand(vote.getId()).toUri();
	    	
	    	
	    	return ResponseEntity.created(location)
	    			.body(new ApiResponse(true, "created successfully"));
	    	
}
	    @GetMapping("/{voteId}")
	    public VoteResponse getVoteById(@CurrentUser UserPrincipal currentUser,
	    								@PathVariable Long voteId){
	    	
	    	return voteService.getVoteById(voteId, currentUser);
	    }
	    @PostMapping("/{voteId}/votes")
	    @PreAuthorize("hasRole('USER')")
	    public VoteResponse castVote(@CurrentUser UserPrincipal currentUser, 
	    							@PathVariable Long voteId,
	    							@Valid @RequestBody VoteRollRequest voteRequest ) {
	    	return voteService.castVoteAndGetUpdatedVote(voteId, voteRequest, currentUser);
	    }
}



