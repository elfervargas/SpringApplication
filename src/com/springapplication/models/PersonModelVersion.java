package com.springapplication.models;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect
public class PersonModelVersion {

	@JsonProperty
	private List<PersonModel> persons;
	@JsonProperty
	private String version;

	public PersonModelVersion() {
	}

	public PersonModelVersion(List<PersonModel> persons, String version) {
		super();
		this.persons = persons;
		this.version = version;
	}

	public List<PersonModel> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonModel> persons) {
		this.persons = persons;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
