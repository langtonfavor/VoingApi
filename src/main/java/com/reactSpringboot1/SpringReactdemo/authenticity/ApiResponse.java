package com.reactSpringboot1.SpringReactdemo.authenticity;


public class ApiResponse {

	private boolean success;
	
	public ApiResponse(boolean success, String message) {
	
		this.success = success;
		this.message = message;
	}

	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
