package com.amit.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.repository.PersonRepository;

@RestController
@RequestMapping(path = {"/v1.0"})
public class PersonController {

	private PersonRepository personRepository;
	
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@RequestMapping(path = {"/invoke/procedure/input/{in}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer plus1inAndout(@PathVariable("in") Integer in) {
		return this.personRepository.invokeProcedure(in);
	}
	
}
