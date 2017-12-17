package com.amdocs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

	public Long countByName(String name);
	
	public List<Todo> findByNameLike(String name);
}
