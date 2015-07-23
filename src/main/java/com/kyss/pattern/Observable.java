package com.kyss.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mathieu SAUVAGE
 */
public class Observable<T> {
    protected List<Observer<T>> views = new ArrayList();

    //<editor-fold desc="Observers management">
    public void addObserver(Observer v) {
        this.views.add(v);
    }

    public void removeObserver(Observer v) {
        this.views.remove(v);
    }
    //</editor-fold>

    public static class Complex<T> extends Observable<T> {
        public static enum EVENT {GRAPHICAL, MODEL}

        protected T model;

        public Complex(T model) {
            this.model = model;

        }

        public void updateObservers(EVENT event) {
            Iterator var2 = this.views.iterator();

            while (var2.hasNext()) {
                Observer v = (Observer) var2.next();
                v.update(event, model);
            }

        }
    }

    public static class Live<T> extends Observable<T> {

        public void updateObservers(T model) {
            Iterator var2 = this.views.iterator();

            while (var2.hasNext()) {
                Observer v = (Observer) var2.next();
                v.update(null, model);
            }

        }
    }
    //</editor-fold>
}