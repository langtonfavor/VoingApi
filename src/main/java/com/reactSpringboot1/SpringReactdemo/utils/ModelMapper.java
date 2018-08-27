package com.reactSpringboot1.SpringReactdemo.utils;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.reactSpringboot1.SpringReactdemo.modal.User;
import com.reactSpringboot1.SpringReactdemo.modal.Vote;
import com.reactSpringboot1.SpringReactdemo.payLoads.ChoiceResponse;
import com.reactSpringboot1.SpringReactdemo.payLoads.UserSummary;
import com.reactSpringboot1.SpringReactdemo.payLoads.VoteResponse;

public class ModelMapper {

	 public static VoteResponse mapPollToPollResponse(Vote vote, Map<Long, Long> choiceVotesMap, User creator, Long userVote) {
	        VoteResponse voteResponse = new VoteResponse();
	        voteResponse.setId(vote.getId());
	        voteResponse.setQuestion(vote.getQuestion());
	        voteResponse.setCreationDateTime(vote.getCreatedAt());
	        voteResponse.setExpirationDateTime(vote.getExpirationDateTime());
	        Instant now = Instant.now();
	        voteResponse.setExpired(vote.getExpirationDateTime().isBefore(now));

	        List<ChoiceResponse> choiceResponses = vote.getChoices().stream().map(choice -> {
	            ChoiceResponse choiceResponse = new ChoiceResponse();
	            choiceResponse.setId(choice.getId());
	            choiceResponse.setText(choice.getText());

	            if(choiceVotesMap.containsKey(choice.getId())) {
	                choiceResponse.setVoteCount(choiceVotesMap.get(choice.getId()));
	            } else {
	                choiceResponse.setVoteCount((long) 0);
	            }
	            return choiceResponse;
	        }).collect(Collectors.toList());

	        
	       voteResponse.setChoices(choiceResponses);
	       UserSummary creatorSummary = new UserSummary(creator.getId(), creator.getUsername(), creator.getName());
	       voteResponse.setCreatedBy(creatorSummary);
	       
	       if(userVote != null) {
	    	   voteResponse.setSelectedchoices(userVote);
	    	   
	    	   
	    	   long totalVotes = voteResponse.getChoices().stream().mapToLong(ChoiceResponse::getVoteCount).sum();
	    	   voteResponse.setTotalVotes(totalVotes);
		
	}
		return voteResponse;
}
}
