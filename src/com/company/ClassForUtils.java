package com.company;

import java.io.File;
import java.util.Iterator;

/**
 * Created by andy on 29.10.2017.
 */

public class ClassForUtils {

    public static void main(String[] args) {
        List list = new LinkList();
        list.add("a");
        list.add("tttt");
        list.add("uoi");
        list.add("8");
        list.displayList();
        Object found = Utils.find(new Predicate() {
            @Override
            public boolean apply(Object o) {
                return "a".equals(o);
            }
        }, list);
        System.out.println(found);
        List list2 = Utils.filter(new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return obj.toString().length() == 1;
            }
        }, list);
        list2.displayList();
        List list3 = Utils.transform(new com.company.Transformer() {
            @Override
            public Object trans(Object obj) {
                Object newObj = obj.toString() + obj.toString();
                return newObj;
            }
        }, list);
        list3.displayList();
        Object arr[] = new Object[]{"sun", "automn", "aa", "spring", "house", "88", "yes"};
        List list4 = Utils.toList(arr);
        list4.displayList();
        List list5 = Utils.intersect(list4, list3, new Predicate2() {
            @Override
            public boolean applyTwo(Object ob1, Object ob2) {
                return ob1.equals(ob2);
            }
        });
        list5.displayList();
        List list6 = Utils.difference(list3, list4, new Predicate2() {
            @Override
            public boolean applyTwo(Object ob1, Object ob2) {
                return ob1.equals(ob2);
            }
        });
        list6.displayList();
        File dir1 = new File("c:/dir1");
        File dir2 = new File("c:/dir2");
        System.out.println(dir1.mkdir() + " " + dir2.mkdir());

        List files1 = Utils.toList(dir1.listFiles());
        List files2 = Utils.toList(dir2.listFiles());
        files1.displayList();
        files2.displayList();
        List duplicated = Utils.difference(files1, files2, new Predicate2() {
            @Override
            public boolean applyTwo(Object ob1, Object ob2) {
                return ob1.equals(ob2);
            }
        });
        duplicated.displayList();
        List list7 = new LinkList();
        List list8 = new LinkList();
        List list9 = new LinkList();

        list7.add(1);
        list7.add(2);
        list7.add(3);
        list7.add(77);

        list8.add(4);
        list8.add(5);
        list8.add(6);

        list9.add(7);
        list9.add(8);
        list9.add(9);

        Iterator view = Utils.viewIterator(list7, list7, list8, list9);

        while (view.hasNext())
            System.out.println(view.next());

        System.out.println("== Iterable ==");

        // Iterable
        for (Object o : Utils.view(list7, list8, list9)) {
            System.out.println(o);
        }
        System.out.println();
        Iterator filterIterator = Utils.filterIterator(list7, new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return obj.toString().length()==2;
            }
        });
        while (filterIterator.hasNext())
        System.out.println(filterIterator.next());
        System.out.println();

        for (Object o : Utils.filterView(list7, new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return obj.toString().length() == 2;
            }
        })) {
            System.out.println(o);
        }


//
//        for (Object o : Utils.view(list7, list8, list9)) {
//            System.out.println(o);
//        }


    }
}
