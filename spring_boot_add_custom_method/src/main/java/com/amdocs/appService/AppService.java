package com.amdocs.appService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.models.Todo;
import com.amdocs.myRepositories.TodoRepository;

@Service
public class AppService {

	@Autowired
	private TodoRepository todoRepository;
	
	
	public Optional<Todo> deleteById(String id) {
		return todoRepository.deleteById(id);
	}
}
