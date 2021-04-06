package com.amit.app.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.app.model.managed.Person;
import com.amit.app.projection.classbased.PersonSummary;

public interface PersonRepository extends JpaRepository<Person, Long> {

	<T> Collection<T> findByLastname(String lastname, Class<T> projectionType);
	
	Collection<PersonSummary> findByFirstname(String firstname);
}
