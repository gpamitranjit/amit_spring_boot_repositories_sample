package com.amdocs.appController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.models.Todo;
import com.amdocs.service.TodoSearchService;
import com.amdocs.service.impl.RepositorysaveTodoService;

@RestController
@RequestMapping("/v1/")
public class AppController {

	private TodoSearchService todoSearchService;
	
	private RepositorysaveTodoService repositorysaveTodoService;
	@Autowired
	AppController(TodoSearchService todoSearchService, RepositorysaveTodoService repositorysaveTodoService) {
		this.todoSearchService = todoSearchService;
		this.repositorysaveTodoService = repositorysaveTodoService;
	}
	
	@RequestMapping(value = "/todos/{searchTerm}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Todo> getalltodos(@PathVariable("searchTerm") String searchTerm) {
		
		return todoSearchService.findBySearchTerm(searchTerm);
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Todo savetodo(@RequestBody Todo todo) {
		return repositorysaveTodoService.save(todo);
	}
}
