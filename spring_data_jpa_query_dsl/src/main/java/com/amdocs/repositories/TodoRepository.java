package com.amdocs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;

import com.amdocs.models.Todo;

public interface TodoRepository extends Repository<Todo, String>, QueryDslPredicateExecutor<Todo> {
	
	void delete(Todo deleted);
	
	List<Todo> findAll();
	
	Optional<Todo> findOne();
	
	void flush();
	
	Todo save(Todo todo);
}
