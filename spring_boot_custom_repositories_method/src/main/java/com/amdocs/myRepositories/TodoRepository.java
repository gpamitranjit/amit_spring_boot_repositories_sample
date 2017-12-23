package com.amdocs.myRepositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.amdocs.models.Todo;

public interface TodoRepository extends Repository<Todo, String>, CustomTodoRepository {

	void delete(Todo todo);
	
	List<Todo> findAll();
	
	Todo save(Todo todo);
}
