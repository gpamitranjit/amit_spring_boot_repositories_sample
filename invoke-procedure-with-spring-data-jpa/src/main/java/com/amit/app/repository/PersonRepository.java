package com.amit.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.amit.app.model.managed.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Procedure(procedureName = "incrementandget")
	public Integer invokeProcedure(int var1);
}
