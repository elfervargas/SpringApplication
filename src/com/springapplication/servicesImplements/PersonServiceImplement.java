package com.springapplication.servicesImplements;

import java.lang.reflect.Type;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.springapplication.models.PersonModel;
import com.springapplication.services.PersonService;

@Service
public class PersonServiceImplement implements PersonService {

	@Override
	public String greeting(String name) {
		return "Hello " + name;
	}

	@Override
	public PersonModel getAPerson(String name, Long years, String gender) {
		return new PersonModel(name, years, gender);
	}

	@Override
	public String getJSON(Object person) {
		Gson gson = new GsonBuilder().create();
		Type type = new TypeToken<Object>() {
		}.getType();
		String response = gson.toJson(person, type);
		return response;
	}
}
