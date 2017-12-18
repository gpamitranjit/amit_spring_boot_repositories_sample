package com.amdocs.service;

import java.util.List;

import com.amdocs.models.Todo;

public interface TodoSearchService {

	List<Todo> findBySearchTerm(String searchTerm);
}
