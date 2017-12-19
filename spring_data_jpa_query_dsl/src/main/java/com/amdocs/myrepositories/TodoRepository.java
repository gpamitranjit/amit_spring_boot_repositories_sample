package com.amdocs.myrepositories;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;

import com.amdocs.models.Todo;


public interface TodoRepository extends Repository<Todo, String>, QueryDslPredicateExecutor<Todo> {
	
	void delete(Todo deleted);
	
	List<Todo> findAll();
	
	void flush();
	
	Todo save(Todo todo);
}
