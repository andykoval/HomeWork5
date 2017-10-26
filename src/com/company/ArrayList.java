package com.company;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * ArrayList
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
        Object temp = arrlist[0];
        if (arrlist[count] == null)
            return null;
        else {
            System.arraycopy(arrlist, 1, arrlist, 0, arrlist.length - 2);
            arrlist[arrlist.length - 1] = null;
        }
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
        System.arraycopy(arrlist, count + 1, arrlist, count, arrlist.length - (count + 1));
        arrlist[arrlist.length - 1] = null;
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
        } else {
            while (arrlist[count] != null) {
                count++;
                if (count == arrlist.length - 1) {
                    size = (size * 3) / 2 + 1;
                    Object[] tmp = new Object[size];
                    tmp[0] = obj;
                    System.arraycopy(arrlist, 0, tmp, 0, arrlist.length);
                    arrlist = tmp;
                } else if (arrlist[count] == null) {
                    System.arraycopy(arrlist, 0, arrlist, 1, arrlist.length - 1);
                    arrlist[0] = obj;
                    return;
                }
            }
        }
    }

    @Override
    public Object pop() {
        int count = 0;
        Object temp = arrlist[0];
        if (arrlist[count] == null)
            return null;
        else {
            System.arraycopy(arrlist, 1, arrlist, 0, arrlist.length - 2);
            arrlist[arrlist.length - 2] = null;
        }
        return temp;
    }
    @Override
    public Iterator iterator() {
        Iterator  it = new Iterator() {
            int currentindex = 0;
//            int size = size();

            @Override
            public boolean hasNext() {
                return currentindex < arrlist.length && arrlist[currentindex]!=null;
            }

            @Override
            public Object next() {
                return arrlist[currentindex++];
            }
        };
        return it;
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
        arrayList.push("STACKadd3");
        arrayList.push("STACKadd4");
        arrayList.push("STACKadd5");
        arrayList.push("STACKadd6");
        arrayList.push("STACKadd7");
        arrayList.push("STACKadd8");
        arrayList.push("STACKadd9");
        arrayList.push("STACKadd10");
        arrayList.push("STACKadd11");
        arrayList.push("STACKadd12");
        arrayList.push("STACKadd13");
        arrayList.push("STACKadd14");
        arrayList.push("STACKadd15");
        arrayList.push("STACKadd16");
        arrayList.displayList();
        for (int i = 0; i < 10; i++)
            arrayList.pop();
        arrayList.displayList();


        ArrayList listIter = new ArrayList(10);
        Iterator it = listIter.iterator();
        listIter.add("Lets");
        listIter.add("test");
        listIter.add("iter");
        listIter.displayList();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }
        for(Object o: listIter)
            System.out.println(o);


//        System.out.println("sdadsa "+it.next()+" "+it.hasNext());

    }
}