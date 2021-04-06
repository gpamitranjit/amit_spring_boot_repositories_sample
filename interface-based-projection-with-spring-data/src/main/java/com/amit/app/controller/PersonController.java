package com.amit.app.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.managed.Person;
import com.amit.app.projection.interfacebased.NameOnly;
import com.amit.app.projection.interfacebased.PersonSummary;
import com.amit.app.repository.PersonRepository;

@RestController
@RequestMapping(path = {"/v1.0"})
public class PersonController {

	private PersonRepository personRepository;
	
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@RequestMapping(path = {"/person"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person storePersonData(@RequestBody Person person) {
		return this.personRepository.save(person);
	}
	
	@RequestMapping(path = {"/parial-projection/person/nameonly/{lastname}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<NameOnly> retrieveNameOnlyProjection(@PathVariable("lastname") String lastname) {
		return this.personRepository.findByLastname(lastname);
	}
	
	@RequestMapping(path = {"/parial-projection/person/personsummary/{firstname}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<PersonSummary> retrievePersonSummaryProjection(@PathVariable("firstname") String firstname) {
		return this.personRepository.findByFirstname(firstname);
	}
	
}
