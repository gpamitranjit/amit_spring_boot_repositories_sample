package com.amit.app.transformation;

import java.util.Collections;
import java.util.List;

public interface TypeSafeTransformer<T, V> {

	public V transform(T input);
	
	public default List<V> transform(List<T> listInput) {
		return Collections.emptyList();
	}
}
