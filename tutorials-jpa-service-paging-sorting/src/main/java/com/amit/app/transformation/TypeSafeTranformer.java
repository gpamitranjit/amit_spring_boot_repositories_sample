package com.amit.app.transformation;

import java.util.Collections;
import java.util.List;

public interface TypeSafeTranformer<T, U> {

	public U transform(T t);
	
	public default List<U> transform(List<T> t) {
		return Collections.emptyList();
	}
}
