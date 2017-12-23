package com.amdocs.myRepositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.amdocs.models.TodoSearchResultDTO;

/**
 * @author Amit
 *
 */
public class TodoRepositoryImpl implements CustomTodoRepository {

	private static final String SEARCH_TODO_ENTRIES = "SELECT t.id, t.title FROM todos t  where LOWER(t.title) LIKE LOWER(CONCAT('%', :searchTerm, '%'))  OR LOWER(t.description) LIKE LOWER(CONCAT('%', :searchTerm, '%')) ORDER BY t.title ASC";
	
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	public TodoRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
		
	@Override
	public List<TodoSearchResultDTO> findBySearchTerm(String searchTerm) {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("searchTerm", searchTerm);
		List<TodoSearchResultDTO> searchResults = jdbcTemplate.query(SEARCH_TODO_ENTRIES, queryParams, new BeanPropertyRowMapper<>(TodoSearchResultDTO.class));
		
		return searchResults;
	}

	public TodoRepositoryImpl() {
		super();
		this.jdbcTemplate = null;
	}
}
