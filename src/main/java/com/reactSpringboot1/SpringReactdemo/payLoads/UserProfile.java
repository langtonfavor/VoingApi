package com.reactSpringboot1.SpringReactdemo.payLoads;

import java.time.Instant;

public class UserProfile {

	private Long id;
	private String username;
	private String name;
	private Instant joinedAt;
	private Long voteAccount;
	private Long voteRollCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Instant getJoinedAt() {
		return joinedAt;
	}
	public void setJoinedAt(Instant joinedAt) {
		this.joinedAt = joinedAt;
	}
	public Long getVoteAccount() {
		return voteAccount;
	}
	public void setVoteAccount(Long voteAccount) {
		this.voteAccount = voteAccount;
	}
	public Long getVoteRollCount() {
		return voteRollCount;
	}
	public UserProfile(Long id, String username, String name, Instant joinedAt,
			Long voteAccount, Long voteRollCount) {
		
		this.id = id;
		this.username = username;
		this.name = name;
		this.joinedAt = joinedAt;
		this.voteAccount = voteAccount;
		this.voteRollCount = voteRollCount;
	}
	public void setVoteRollCount(Long voteRollCount) {
		this.voteRollCount = voteRollCount;
	}
	
	
}
