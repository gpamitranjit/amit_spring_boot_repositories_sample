package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public Todo saveTodo(@RequestBody Todo todo) {
		return todoService.save(todo);
	}
	
	
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public void deleteTodo(@PathVariable("id") String id) {
		todoService.delete(id);
	}
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Todo> retrieveAllTodos() {
		return todoService.retriveAllTodos();
	}
}
