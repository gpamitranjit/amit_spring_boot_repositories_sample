package com.amdocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.models.Todo;
import com.amdocs.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired
	public TodoRepository todoRepository;
	
	public Long retrievebyName(String name) {
		return todoRepository.countByName(name);
	}
	
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public List<Todo> findbynamelike(String name + "%") {
		return todoRepository.findByNameLike(name);
	}
	
}
