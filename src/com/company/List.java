package com.company;

/**
 * Created by andy on 24.10.2017.
 */
public interface List extends Iterable{
    public void displayList();
    void add(Object obj);
    Object get(int i);
    Object remove(int i);
    int size();

}
