package com.amit.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.app.model.managed.Person;
import com.amit.app.projection.interfacebased.NameOnly;
import com.amit.app.projection.interfacebased.PersonSummary;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Collection<NameOnly> findByLastname(String lastname);
	
	Collection<PersonSummary> findByFirstname(String firstname);
}
