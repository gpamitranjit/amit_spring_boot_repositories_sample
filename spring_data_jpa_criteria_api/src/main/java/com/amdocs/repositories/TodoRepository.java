package com.amdocs.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;
import com.amdocs.models.Todo;

@org.springframework.stereotype.Repository
public interface TodoRepository extends Repository<Todo, String>, JpaSpecificationExecutor<Todo> {
	void delete(Todo todo);
	
	List<Todo> findAll();
	
	Optional<Todo> findOne(String id);
	
	void flush();
	
	Todo save(Todo todo);
}
