package com.company;

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
        Object arr[] = new Object[]{"sun", "automn", "aa","spring", "house", "88", "yes"};
        List list4 = Utils.toList(arr);
        list4.displayList();
        List list5 = Utils.intersect(list4, list3, new Predicate2(){
            @Override
            public boolean applyTwo(Object ob1, Object ob2) {
                return ob1.equals(ob2);
            }
        });
        list5.displayList();
        List list6 = Utils.difference(list3, list4, new Predicate2(){
            @Override
            public boolean applyTwo(Object ob1, Object ob2) {
                return ob1.equals(ob2);
            }
        });
        list6.displayList();
    }
}
