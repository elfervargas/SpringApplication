
package com.springapplication.response;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ResponseFactory {

	@SuppressWarnings("serial")
	public static class SuccessfulResponse implements Serializable {

		@JsonProperty
		private final ResponseStatus response = new ResponseStatus();

		@JsonProperty
		private Map<String, Object> data = new LinkedHashMap<String, Object>();

		public Map<String, Object> getData() {
			return data;
		}

		private boolean success = true;

		private String message = "OK";

		public SuccessfulResponse() {
			this.response.setSuccess(success);
			this.response.setMessage(message);
		}

		public SuccessfulResponse(String message) {
			this.response.setSuccess(success);
			this.response.setMessage(message);
		}

		public SuccessfulResponse(String key, Object value) {
			this.response.setSuccess(success);
			this.response.setMessage(message);
			this.data.put(key, value);
		}

		public SuccessfulResponse(String key, Object value, String message) {
			this.response.setSuccess(success);
			this.response.setMessage(message);
			this.data.put(key, value);
		}

		public SuccessfulResponse addField(String key, Object value) {
			this.data.put(key, value);
			return this;
		}

		@Override
		public String toString() {
			return "SuccessfulResponse [response=" + response + ", data=" + data + "]";
		}

	}

	@SuppressWarnings("serial")
	public static class UnsuccessfulResponse implements Serializable {

		@JsonProperty
		private final ResponseStatus response = new ResponseStatus();

		private boolean success = false;

		private String message = "NOT OK";

		public UnsuccessfulResponse() {
			this.response.setSuccess(success);
			this.response.setMessage(message);
		}

		public UnsuccessfulResponse(String message) {
			this.response.setSuccess(success);
			this.response.setMessage(message);
		}

	}

	public static SuccessfulResponse successfulResponse() {
		SuccessfulResponse sr = new SuccessfulResponse();
		return sr;
	}

	public static SuccessfulResponse successfulResponse(String message) {
		SuccessfulResponse sr = new SuccessfulResponse(message);
		return sr;
	}

	public static SuccessfulResponse successfulResponse(String key, Object value) {
		SuccessfulResponse sr = new SuccessfulResponse(key, value);
		return sr;
	}

	public static SuccessfulResponse successfulResponse(String key, Object value, String message) {
		SuccessfulResponse sr = new SuccessfulResponse(key, value, message);
		return sr;
	}

	public static UnsuccessfulResponse unsuccessfulResponse() {
		UnsuccessfulResponse ur = new UnsuccessfulResponse();
		return ur;
	}

	public static UnsuccessfulResponse unsuccessfulResponse(String message) {
		UnsuccessfulResponse ur = new UnsuccessfulResponse(message);
		return ur;
	}

}
