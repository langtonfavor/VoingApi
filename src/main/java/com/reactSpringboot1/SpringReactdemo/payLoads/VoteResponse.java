package com.reactSpringboot1.SpringReactdemo.payLoads;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class VoteResponse {

	private Long id;
    private String question;
    private List<ChoiceResponse>choices;
    private UserSummary createdBy;
    private Instant creationDateTime;
    private Instant expirationDateTime;
    private boolean expired;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long selectedchoices;
    private Long totalVotes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<ChoiceResponse> getChoices() {
		return choices;
	}
	public void setChoices(List<ChoiceResponse> choices) {
		this.choices = choices;
	}
	public UserSummary getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserSummary createdBy) {
		this.createdBy = createdBy;
	}
	public Instant getCreationDateTime() {
		return creationDateTime;
	}
	public void setCreationDateTime(Instant creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	public Instant getExpirationDateTime() {
		return expirationDateTime;
	}
	public void setExpirationDateTime(Instant expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public Long getSelectedchoices() {
		return selectedchoices;
	}
	public void setSelectedchoices(Long selectedchoices) {
		this.selectedchoices = selectedchoices;
	}
	public Long getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(Long totalVotes) {
		this.totalVotes = totalVotes;
	}
	public VoteResponse(Long id, String question, List<ChoiceResponse> choices,
			UserSummary createdBy, Instant creationDateTime,
			Instant expirationDateTime, boolean expired, Long selectedchoices,
			Long totalVotes) {
		
		this.id = id;
		this.question = question;
		this.choices = choices;
		this.createdBy = createdBy;
		this.creationDateTime = creationDateTime;
		this.expirationDateTime = expirationDateTime;
		this.expired = expired;
		this.selectedchoices = selectedchoices;
		this.totalVotes = totalVotes;
	}
	public VoteResponse() {
		// TODO Auto-generated constructor stub
	}
    
}
