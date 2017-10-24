package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class Link {
    public Object data;
    public Link next;

    public Link(Object data) {
        this.data = data;
        next = null;
    }

    public void displayLink() {
        System.out.print("{" + data + "}");
    }
}
