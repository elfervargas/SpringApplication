package com.springapplication.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springapplication.gzip.GzipResponse;
import com.springapplication.models.PersonModel;
import com.springapplication.models.PersonModelVersion;
import com.springapplication.response.ResponseFactory;
import com.springapplication.services.PersonService;

@RestController
public class IndexRestController {

	@SuppressWarnings("unused")
	@Autowired
	private PersonService service;

	@GzipResponse
	@RequestMapping(value = "/personversion", method = RequestMethod.POST)
	public Object getPersonModel(@RequestBody PersonModelVersion personVersion) {
		List<Map<String, Object>> resultado = new ArrayList<Map<String, Object>>();
		List<PersonModel> persons = personVersion.getPersons();
		for (PersonModel person : persons) {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("person", person);
			resultado.add(temp);
		}
		// return ResponseFactory.successfulResponse("result", resultado);
		return service.getJSON(ResponseFactory.successfulResponse("result", resultado));
	}

	@GzipResponse
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Object getPerson(@RequestBody PersonModel person) {
		List<Map<String, Object>> resultado = new ArrayList<Map<String, Object>>();
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("person", person);
		resultado.add(temp);
		return ResponseFactory.successfulResponse("result", resultado);
	}

	@GzipResponse
	@RequestMapping(value = "test", method = RequestMethod.POST)
	public Object index(@RequestBody PersonModel person) {
		ArrayList<Object> list = new ArrayList<Object>();
		for (int i = 0; i < 10; i++) {
			list.add(new PersonModel("Person", Long.parseLong(i + ""), "Male"));
		}
		String response = service.getJSON(list);
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("json", response);
		return response;
	}
}
