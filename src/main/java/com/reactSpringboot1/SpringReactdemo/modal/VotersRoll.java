package com.reactSpringboot1.SpringReactdemo.modal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.reactSpringboot1.SpringReactdemo.modal.audit.DateAudit;


//this class contains informtion of who voted for who


@Entity
@Table(name = "voter_roll", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "poll_id",
                "user_id"
        })
})
public class VotersRoll extends DateAudit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public VotersRoll() {
		
	}


	public VotersRoll(Long id, Choice choice, User user, Vote vote) {
		
		this.id = id;
		this.choice = choice;
		this.user = user;
		this.vote = vote;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Choice getChoice() {
		return choice;
	}


	public void setChoice(Choice choice) {
		this.choice = choice;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Vote getVote() {
		return vote;
	}


	public void setVote(Vote vote) {
		this.vote = vote;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	   @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "choice_id", nullable = false)
	    private Choice choice;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	    

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "poll_id", nullable = false)
	    private Vote vote;

}
