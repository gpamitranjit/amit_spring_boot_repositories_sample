package com.amdocs.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amdocs.models.Todo;
import com.amdocs.myrepositories.TodoRepository;
import com.amdocs.predicates.TodoPredicates;
import com.mysema.query.types.Predicate;




@Service
public class RepositoryTodoSearchService implements TodoSearchService {

	private static final String SORT_PROPERTY = "name";
	
	@Autowired(required = true)
	private TodoRepository todoRepository;
	private static Pageable pageRequest;
	private static final int PAGE_NUMBER = 1;
	private static final int PAGE_SIZE = 4;
//	private static Logger logger = LoggerFactory.getLogger(RepositoryTodoSearchService.class);
	
		
	@PostConstruct
	public static void createPageRequest() {
//		logger.info("creating the page!");
		Sort sort = new Sort(Sort.Direction.ASC, SORT_PROPERTY);
		pageRequest = new PageRequest(PAGE_NUMBER, PAGE_SIZE, sort);
		
		Page<Todo> emptyPage = new PageBuilder<Todo>()
				.elements(new ArrayList<Todo>())
				.pageRequest(pageRequest)
				.totalElements(0)
				.build();
	}
	
	@Override
	public List<Todo> findBySearchTerm(String searchTerm) {
		System.out.println("inside findBySearchTerm()");
//		logger.info("inside findBySearchTerm() method");
		Predicate predicate = TodoPredicates.hasName(searchTerm);
		Iterable<Todo> todos = todoRepository.findAll(predicate, pageRequest);
		List<Todo> todosList = new ArrayList<Todo>();
		Iterator<Todo> it = todos.iterator();
		while(it.hasNext()) {
			todosList.add(it.next());
		}
		
		return todosList;
	}

}
