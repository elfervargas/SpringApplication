package com.springapplication.services;

import org.springframework.stereotype.Service;

import com.springapplication.models.PersonModel;

@Service
public interface PersonService {
	public String greeting(String name);

	public PersonModel getAPerson(String name, Long years, String gender);

	public String getJSON(Object person);
}
