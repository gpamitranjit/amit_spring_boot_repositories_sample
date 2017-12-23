package com.amdocs.myRepositories;

import java.util.List;
import com.amdocs.models.TodoSearchResultDTO;

/**
 * @author Amit
 *
 */
interface CustomTodoRepository {
 
    List<TodoSearchResultDTO> findBySearchTerm(String searchTerm);
}