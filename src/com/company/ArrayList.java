package com.company;

/**
 * Created by andy on 25.10.2017.
 */
public class ArrayList implements List, Stack, Queue {

    private Object[] arrlist;
    private int size;

    private ArrayList(int size) {
        arrlist = new Object[size];
        this.size = size;
    }

    private void displayList() {
        int count = 0;
        if (arrlist[count] == null) {
            System.out.println("Пустой массив");
            return;
        }
        System.out.print("\nЭлементы масcива: ");
        while (arrlist[count] != null) {
            System.out.print(arrlist[count] + " ");
            count++;
        }
        System.out.println();
    }

    @Override
    public void add(Object obj) {
        int count = 0;
        if (arrlist[count] == null) {
            arrlist[count] = obj;
            return;
        }
        while (arrlist[count] != null)
            count++;
        if (count == size - 1) {
            size = (size * 3) / 2 + 1;
            Object[] tmp = new Object[size];
            System.arraycopy(arrlist, 0, tmp, 0, arrlist.length);
            arrlist = tmp;
        }
        arrlist[count] = obj;
    }

    @Override
    public Object poll() {
        int count = 0;
        if (arrlist[0] == null)
            return null;
        Object temp = arrlist[0];
        Object[] tmp = new Object[size - 1];
        for (int i = 1; i < size - 1; i++)
            tmp[i - 1] = arrlist[i];
        arrlist = tmp;
        return temp;
    }

    @Override
    public Object get(int i) {
        int count = 0;
        while (count != i)
            count++;
        if (arrlist[count] == null)
            return null;
        return arrlist[count];
    }

    @Override
    public Object remove(int i) {
        int count = 0;
        while (count != i)
            count++;
        Object temp = arrlist[count];
        Object[] tmp = new Object[size - 1];
        for (int j = 0; j < count; j++)
            tmp[j] = arrlist[j];
        for (int j = count; j < size - 2; j++)
            tmp[j] = arrlist[j + 1];
        arrlist = tmp;
        return temp;
    }

    @Override
    public int size() {
        int count = 0;
        while (arrlist[count] != null)
            count++;
        return count;
    }

    @Override
    public void push(Object obj) {
        int count = 0;
        if (arrlist[count] == null) {
            arrlist[count] = obj;
            return;
        } else {
            Object[] tmp = new Object[size + 1];
            tmp[0] = obj;
            for (int i = 0; i < size - 1; i++) {
                tmp[i + 1] = arrlist[i];
            }
            arrlist = tmp;
        }
    }

    @Override
    public Object pop() {
        int count = 0;
        Object temp = arrlist[0];
        if (arrlist[count] == null)
            return null;
        else {
            Object[] tmp = new Object[size - 1];
            for (int i = 0; i < size - 2; i++)
                tmp[i] = arrlist[i + 1];
            arrlist = tmp;
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.displayList();
        arrayList.add("Somthing");
        arrayList.add("just");
        arrayList.add("like");
        arrayList.add("this");
        arrayList.add("!");
        arrayList.add("!!");
        arrayList.add("this");
        arrayList.add("is");
        arrayList.add("the");
        arrayList.add("long");
        arrayList.add("story");
        arrayList.add("..");
        arrayList.add("today");
        arrayList.displayList();
        System.out.println(arrayList.poll());
        System.out.println(arrayList.poll());
        System.out.println(arrayList.poll());
        arrayList.displayList();
        System.out.println("Размер масcива: " + arrayList.size());
        System.out.println("Элемент по индексу: " + arrayList.get(4));
        System.out.println("Удаление элемента по индексу: " + arrayList.remove(5));
        arrayList.displayList();
        arrayList.push("STACKadd1");
        arrayList.push("STACKadd2");
        arrayList.displayList();
        arrayList.pop();
        arrayList.displayList();

    }
}
