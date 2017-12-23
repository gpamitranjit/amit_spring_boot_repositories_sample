package com.amdocs.appService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.models.TodoSearchResultDTO;
import com.amdocs.myRepositories.TodoRepository;

@Service
public class AppService {

	@Autowired
	private TodoRepository todoRepository;
	
	
	public List<TodoSearchResultDTO> retrieveCustomObjects(String searchTerm) {
		return todoRepository.findBySearchTerm(searchTerm);
	}
}
