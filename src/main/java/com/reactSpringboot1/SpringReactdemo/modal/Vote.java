package com.reactSpringboot1.SpringReactdemo.modal;

//import java.awt.Choice;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



import com.reactSpringboot1.SpringReactdemo.modal.audit.UserDateAudit;


@Entity
@Table(name="votes")
public class Vote extends UserDateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=2, max=20)
	private String question;
	
	@OneToMany(
			mappedBy="vote",
			cascade = CascadeType.ALL,
			orphanRemoval=true
			)
	@Size(min=2, max=20)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size=30)
	 private List<Choice> choices = new ArrayList<>();
	
	private Instant expirationDateTime;

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

	

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public Instant getExpirationDateTime() {
		return expirationDateTime;
	}

	public void setExpirationDateTime(Instant expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}
}
