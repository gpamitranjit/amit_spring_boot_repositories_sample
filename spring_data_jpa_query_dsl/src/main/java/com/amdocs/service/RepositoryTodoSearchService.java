package com.amdocs.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amdocs.models.Todo;
import com.amdocs.predicates.TodoPredicates;
import com.amdocs.repositories.TodoRepository;
import com.mysema.query.types.Predicate;



@Service
public class RepositoryTodoSearchService implements TodoSearchService {

	private final TodoRepository todoRepository;
	
	@Autowired
	public RepositoryTodoSearchService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@Override
	public List<Todo> findBySearchTerm(String searchTerm) {
		Predicate predicate = TodoPredicates.hasName(searchTerm);
		Iterable<Todo> todos = todoRepository.findAll(predicate);
		List<Todo> todosList = new ArrayList<Todo>();
		Iterator<Todo> it = todos.iterator();
		while(it.hasNext()) {
			todosList.add(it.next());
		}
		
		return todosList;
	}

}
