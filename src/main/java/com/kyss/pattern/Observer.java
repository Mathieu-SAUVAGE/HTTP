package com.kyss.pattern;

import com.kyss.pattern.Observable.Complex.EVENT;

/**
 * @author Mathieu SAUVAGE
 */
public interface Observer<T> {
	void update(EVENT event,T model);
}
