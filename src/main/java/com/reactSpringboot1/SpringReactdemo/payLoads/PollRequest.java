package com.reactSpringboot1.SpringReactdemo.payLoads;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PollRequest {

	@NotBlank
	@Size(min=2, max=30)
	@Valid
	private String question;
	
	@NotNull
	@Valid
	private List<ChoiceRequest>choices;
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<ChoiceRequest> getChoices() {
		return choices;
	}

	public void setChoices(List<ChoiceRequest> choices) {
		this.choices = choices;
	}

	@NotNull
	@Valid
	 private PollLength pollLength;
}
