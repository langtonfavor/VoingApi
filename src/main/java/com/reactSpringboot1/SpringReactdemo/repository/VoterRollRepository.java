package com.reactSpringboot1.SpringReactdemo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reactSpringboot1.SpringReactdemo.modal.ChoiceVoteCount;
import com.reactSpringboot1.SpringReactdemo.modal.Vote;

/**
 * @author MR L
 *
 */
public interface VoterRollRepository extends JpaRepository<Vote, Long>{
    
	@Query("SELECT NEW com.reactSpringboot1.SpringReactdemo.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM VoteRoll v WHERE v.voteRoll.id in :voteIds GROUP BY v.choice.id")	
    List<ChoiceVoteCount>countByVoteIdInGroupByChoiceId(@Param("voteIds")List<Long>voteId);
	
	@Query("SELECT NEW com.reactSpringboot1.SpringReactdemo.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM VoteRoll v WHERE v.voteRoll.id in :voteIds GROUP BY v.choice.id")	
	List<ChoiceVoteCount>countByVoteIdInGroupByChoiceId(@Param("voteId")Long voteId);
	
	@Query("SELECT NEW com.reactSpringboot1.SpringReactdemo.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM VoteRoll v WHERE v.voteRoll.id in :voteIds GROUP BY v.choice.id")	    Vote findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);

    long countByUserId(@Param("userId") Long userId);

    @Query("SELECT NEW com.reactSpringboot1.SpringReactdemo.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM VoteRoll v WHERE v.voteRoll.id in :voteIds GROUP BY v.choice.id")	
    Page<Long> findVotedRollIdsByUserId(@Param("userId") Long userId, Pageable pageable);
}
