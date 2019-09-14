package me.bristermitten.plumber.util.struct;

import java.util.HashSet;

public class ReturningHashSet<T> extends HashSet<T> {

    public T doAdd(T t) {
        add(t);
        return t;
    }
}
