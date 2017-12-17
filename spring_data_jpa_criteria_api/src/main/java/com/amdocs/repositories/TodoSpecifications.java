package com.amdocs.repositories;

import org.springframework.data.jpa.domain.Specification;
import com.amdocs.models.*;

final public class TodoSpecifications {
	
	TodoSpecifications() {}
	
	public static Specification<Todo> nameOrDescriptionContainsIgnoreCase(String searchTerm) {
		return (root, query, cb) -> {
			String containsLikepattern = getContainsLikePattern(searchTerm);
			return cb.or(cb.like(cb.lower(root.<String>get(Todo_.name)), containsLikepattern),
						 cb.like(cb.lower(root.<String>get(Todo_.description)), containsLikepattern));
		};
	}
	
	private static String getContainsLikePattern(String searchTerm) {
		if(searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		}
		else {
			return "%" + searchTerm.toLowerCase() + "%";
		}
	}
}
