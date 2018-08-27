package com.reactSpringboot1.SpringReactdemo.authenticity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

	@NotBlank
	@Size(min = 4, max=40)
	private String name;
	
	@NotBlank
	@Size(min = 4, max=40)

	private String username;

	@NotBlank
	@Size(min = 4, max=40)

	private String password;
	
	public SignUpRequest(@NotBlank @Size(min = 4, max = 40) String name,
			@NotBlank @Size(min = 4, max = 40) String username,
			@NotBlank @Size(min = 4, max = 40) String password,
			@NotBlank @Email String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotBlank
	@Email
	private String email;
}
