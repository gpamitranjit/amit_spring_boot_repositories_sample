package com.amdocs.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM TODOs AS t WHERE t.id= :id", nativeQuery = true)
	public void delete(@Param("id") String id);
	
	@Transactional()
	public T save(T todo);
	
	@Transactional(readOnly = true)
//	@Query(name = "Todo.com.amdocs.repositories.TodoRepository.retriveAllTodos", value = "SELECT t FROM Todo t")
	public List<T> findAll();
}
