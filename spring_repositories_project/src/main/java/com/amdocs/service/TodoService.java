package com.amdocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amdocs.models.Todo;
import com.amdocs.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Transactional
	public void delete(String id) {
		todoRepository.delete(id);
	}
	
	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public List<Todo> retriveAllTodos() {
		return todoRepository.findAll();
	}
}
