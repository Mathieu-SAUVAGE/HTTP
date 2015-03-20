package com.kyss.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mathieu SAUVAGE
 */
public class Observable<T> {
	protected List<Observer<T>> views = new ArrayList();
	protected T model;

	public Observable(T model) {
		this.model = model;
	}

	//<editor-fold desc="Observers management">
	public void addObserver(Observer v) {
		this.views.add(v);
	}

	public void removeObserver(Observer v) {
		this.views.remove(v);
	}

	public void updateObservers() {
		Iterator var2 = this.views.iterator();

		while(var2.hasNext()) {
			Observer v = (Observer)var2.next();
			v.update(model);
		}

	}
	//</editor-fold>
}