package com.company;


import java.util.Iterator;


/**
 * Created by andy on 22.10.2017.
 */
public class LinkList implements List, Stack, Queue {
    private Link first;

    //метод отображает элементы списка
    @Override
    public void displayList() {
        Link newLink;
        newLink = first;
        System.out.print("Элементы списка: ");
        while (newLink != null) {
            newLink.displayLink();
            newLink = newLink.next;
        }
        System.out.println("");
    }

    private boolean isEmpty() {
        return (first == null);
    }


    @Override
    public void add(Object obj) {
        Link newLink = new Link(obj);
        Link current = first;
        if (isEmpty())
            first = newLink;
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newLink;
        }
    }

    @Override
    public Object poll() {
        Link current = first;
        if (isEmpty()) return null;
        first = first.next;
        return current;
    }

    @Override
    public Object get(int i) {
        Link current = first;
        int count = 0;
        if (isEmpty())
            return null;
        else {
            while (count++ != i) {
                if (current.next == null)
                    return null;
                current = current.next;
            }
        }
        return current;
    }

    @Override
    public Object remove(int i) {
        Link current = first;
        Link previous = first;
        int count = 0;
        if (isEmpty()) return null;
        if (first.next == null) {
            first = null;
            return first;
        }
        while (count++ != i) {
            if (current.next == null)
                return null;
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }

    @Override
    public int size() {
        int count = 0;
        Link current = first;
        if (isEmpty()) return 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void push(Object obj) {
        Link newLink = new Link(obj);
        if (isEmpty())
            first = newLink;
        else {
            newLink.next = first;
            first = newLink;
        }
    }

    @Override
    public Object pop() {
        Link current = first;
        if (isEmpty()) return null;
        first = first.next;
        return current;
    }

    public class IteratorNew implements Iterator {
        Link next;

        public IteratorNew(Link next) {
            this.next = next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            Link res = next;
            next = next.next;
            return res.data;
        }
    }

    @Override
    public Iterator iterator() {
        return new IteratorNew(first);
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        System.out.println("\tДобавление элементов очереди");
        list.add("What");
        list.add("else");
        list.add("is");
        list.add("there");
        list.add("?");
        list.displayList();
        System.out.println("Размер: " + list.size());
        System.out.println("\tУдаление элементов очереди");
        int size = list.size();
        for (int j = 0; j < size; j++) {
            list.poll();
            list.displayList();
        }
        System.out.println("Список очищен!");
//      стек
        System.out.println("\tДобавление элементов стека");
        list.push("ack");
        list.push("St");
        list.push("do");
        list.push("to");
        list.push("trying");
        list.push("OK...");
        list.displayList();
        System.out.println("\tУдаление одного элемента стека");
        list.pop();
        list.displayList();
        System.out.println("\tУдаление элемента стека по индексу");
        list.remove(2);
        list.displayList();
        System.out.println("\tВывод на экран одного элемента стека по индексу");
        System.out.println(list.get(1));
        LinkList listIter = new LinkList();
        listIter.add("Lets");
        listIter.add("test");
        listIter.add("iter");
        listIter.add("iter");
        listIter.add("iter");
        listIter.displayList();
//        Iterator listIt = listIter.iterator();
//        while (listIt.hasNext()){
//            Object o = listIt.next();
//            System.out.println(o);
//        }
//        System.out.println();
//        for(Object o: listIter)
//            System.out.println(o);
        Iterator iter = listIter.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());


    }
}