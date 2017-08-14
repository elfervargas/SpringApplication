package com.springapplication.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springapplication.models.PersonModel;
import com.springapplication.models.PersonModelVersion;
import com.springapplication.services.PersonService;

@Controller
public class IndexController {
	@Autowired
	private PersonService service;

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<PersonModel> list = new ArrayList<PersonModel>();
		for(int i = 0; i<10; i++) {
			list.add(new PersonModel("Person",Long.parseLong(i+""), "Male"));
		}
		PersonModelVersion pv = new PersonModelVersion(list,"1.0");
		String response = service.getJSON(pv);
		mav.addObject("response", response);
		return mav;
	}

	@RequestMapping("hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("response", service.greeting("Fernando"));
		return mav;
	}
}
