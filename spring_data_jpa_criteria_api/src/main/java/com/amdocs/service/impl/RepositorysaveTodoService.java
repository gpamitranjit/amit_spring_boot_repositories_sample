package com.amdocs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.models.Todo;
import com.amdocs.repositories.TodoRepository;

@Service
public class RepositorysaveTodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}
}
