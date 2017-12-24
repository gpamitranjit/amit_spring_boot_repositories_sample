package com.amdocs.myRepositories;

import java.util.List;

import com.amdocs.models.Todo;

/**
 * @author Amit
 *
 */
public interface TodoRepository extends BaseRepository<Todo, String> {
	
	List<Todo> findAll();
	
	Todo save(Todo todo);

	
}
