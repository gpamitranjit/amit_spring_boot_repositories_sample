package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.models.Todo;
import com.amdocs.service.TodoService;

@RestController
@RequestMapping("/v1/")
public class AppController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value = "/countbyname/{name}", method = RequestMethod.GET)
	public Long countAllTodosByName(@PathVariable("name") String name) {	
		return todoService.retrievebyName(name);
	}
	
	@RequestMapping(value = "/todo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public Todo savetodo(@RequestBody Todo todo) {
		return todoService.saveTodo(todo);
	}
	
	@RequestMapping(value = "/find/todos/like/{name}")
	public List<Todo> findbynamelike(@PathVariable("name") String name) {
		return todoService.findbynamelike(name);
	}
	
}
