package com.springapplication.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResponseStatus {
	private boolean success;
	private String message;

	public ResponseStatus(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public ResponseStatus() {

	}

	public boolean getSuccess() {
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
