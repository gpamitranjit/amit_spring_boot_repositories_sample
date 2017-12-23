package com.amdocs.appController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.appService.AppService;
import com.amdocs.models.TodoSearchResultDTO;

@RestController
public class AppController {

	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/retrievecustomobjects/{searchTerm}")
	public List<TodoSearchResultDTO>retrieveCustomObjects(@PathVariable("searchTerm") String searchTerm) {
		return appService.retrieveCustomObjects(searchTerm);
	}
}
