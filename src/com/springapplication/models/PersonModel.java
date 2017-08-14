package com.springapplication.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect
public class PersonModel {
	@JsonProperty
	private String name;
	@JsonProperty
	private Long year;
	@JsonProperty
	private String gender;

	public PersonModel() {
		super();
	}

	public PersonModel(String name, Long year, String gender) {
		super();
		this.name = name;
		this.year = year;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
