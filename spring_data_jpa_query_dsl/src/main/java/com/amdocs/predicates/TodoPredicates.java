package com.amdocs.predicates;

import com.amdocs.models.QTodo;
import com.mysema.query.types.Predicate;

public class TodoPredicates {

	private TodoPredicates() {}
	
	public static Predicate hasName(String name) {
	
		if(name ==null || name.isEmpty()) {
			return QTodo.todo.isNotNull();
		}
		else {
			return QTodo.todo.name.eq(name);
		}
		
		
	}
	
	public static Predicate toalDistinctCount() {
		return QTodo.todo.name.countDistinct().goe(0);
	}
	
}
