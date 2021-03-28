package com.amit.app.transformation;

import java.util.List;

public interface TypeSafeTransformer<T, U> {

	public U transform(T t);
	
	public List<U> transform(List<T> t);
}
