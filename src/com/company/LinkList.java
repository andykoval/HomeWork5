package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class LinkList implements List, Stack, Queue {
    private Link first;

    //метод добавляет элемент на первую позицию
    private void addFirst(Object data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    private Object findLinkInd(int index) {
        Link newLink = first;
        int count = 0;
        if (isEmpty())
            return 0;
        while (newLink != null) {
            if (count++ == index)
                return newLink.data;
            newLink = newLink.next;
        }
        return 0;
    }

        private Link deliteFirst() {
        Link temp = first;
        first = temp.next;
        return temp;
    }

    //метод отображает элементы списка
    private void displayList() {
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

    private Link findLink(Object obj) {
        Link current = first;
        while (current.data != obj) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    private Link deliteLink(Object obj) {
        Link current = first;
        Link previous = first;
        while (current.data != obj) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
            if (current == first)
                first = first.next;
            else {
                previous.next = current.next;
            }
        }
        return current;
    }

    private Object getLast() {
        Link newLink = first;
        int count = 0;
        if (isEmpty())
            return 0;
        while (count++ != (size() - 1))
            newLink = newLink.next;
        return newLink.data;
    }


    @Override
    public void add(Object obj) {
        Link newLink = new Link(obj);
        Link current =first;
        if (isEmpty())
            first = newLink;
        else {
            while (current.next!=null){
                current = current.next;
            }
            current.next = newLink;
        }
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public int size() {
        int count =0;
        Link current = first;
        if(isEmpty()) return  0;
        while (current!=null){
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void push(Object obj) {

    }

    @Override
    public Object pop() {
        return null;
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addFirst("that is the question");
        list.addFirst("?");
        list.addFirst("to be");
        list.addFirst("or not");
        list.addFirst("to be");
        list.addFirst("that is the question");
        list.addFirst("?");
        list.addFirst("to be");
        list.addFirst("or not");
        list.addFirst("to be");
        list.displayList();
        Link linkF = list.findLink("to be");
        System.out.println("Поиск элемента по объекту: " + "{" + linkF.data + "}");
        Link linkDel = list.deliteLink("or not");
        System.out.println("Удален элемент по объекту: " + linkDel.data);
        System.out.print("Список после удаления: ");
        list.displayList();
        System.out.println("Размер списка: " + list.size());
        System.out.println("Элемент по индексу: " + list.findLinkInd(2));
        System.out.println("Последний элемент в списке: " + list.getLast());
        System.out.println("Удаление всех элементов списка: ");
        while (!list.isEmpty()) {
            Link linkDelFirst = list.deliteFirst();
            System.out.println("Удален элемент: " + linkDelFirst.data);
        }
        System.out.println("Список очищен!");
        list.add("What");
        list.add("else");
        list.add("is");
        list.add("there");
        list.add("?");

        list.displayList();
    }

}
