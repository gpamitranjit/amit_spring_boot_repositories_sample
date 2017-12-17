package com.amdocs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.amdocs.models.Todo;
import com.amdocs.repositories.TodoRepository;
import com.amdocs.repositories.TodoSpecifications;
import com.amdocs.service.TodoSearchService;

@Service
public class RepositoryTodoSearchService implements TodoSearchService {

	private final TodoRepository todoRepository;
	
	@Autowired
	public RepositoryTodoSearchService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	@Override
	public List<Todo> findBySearchTerm(String searchTerm) {
		Specification<Todo> searchSpecification = TodoSpecifications.nameOrDescriptionContainsIgnoreCase(searchTerm);
		List<Todo> todos = todoRepository.findAll(searchSpecification);
		return todos;
	}

}
