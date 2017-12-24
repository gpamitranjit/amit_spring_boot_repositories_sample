package com.amdocs.appController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.appService.AppService;
import com.amdocs.models.Todo;

@RestController
public class AppController {

	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Todo> deleteById(@PathVariable("id") String id) {
		return appService.deleteById(id);
	}
}
