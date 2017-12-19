package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.models.Todo;
import com.amdocs.service.TodoSearchService;

@RestController
public class AppController {

	@Autowired
	private TodoSearchService service;
	
	@RequestMapping("/{name}")
	public List<Todo> searchbyname(@PathVariable("name") String name) {
		return service.findBySearchTerm(name);
	}
	
	@RequestMapping("/todos/totaldistinctcount")
	public Long getAllDistintCount() {
		return service.getcount();
	}
}
