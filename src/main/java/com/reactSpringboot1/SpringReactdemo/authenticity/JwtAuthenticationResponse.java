package com.reactSpringboot1.SpringReactdemo.authenticity;


public class JwtAuthenticationResponse {

	private String accessResponse;
	
	private String tokenType = "berrer";

	public JwtAuthenticationResponse(String accessResponse) {
		
		this.accessResponse = accessResponse;
	}

	public String getAccessResponse() {
		return accessResponse;
	}

	public void setAccessResponse(String accessResponse) {
		this.accessResponse = accessResponse;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
}
