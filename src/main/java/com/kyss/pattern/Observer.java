package com.kyss.pattern;

/**
 * @author Mathieu SAUVAGE
 */
public interface Observer<T> {
	void update(T model);
}
