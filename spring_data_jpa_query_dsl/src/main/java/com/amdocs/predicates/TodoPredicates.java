package com.amdocs.predicates;

import com.amdocs.models.QTodo;
import com.mysema.query.types.Predicate;

public class TodoPredicates {

	private TodoPredicates() {}
	
	public static Predicate hasName(String name) {
		return QTodo.todo.name.eq(name);
	}
}