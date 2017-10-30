package com.company;

/**
 * Created by andy on 27.10.2017.
 */
public class LazyAccumulator {
    List list;
    int value;

    public LazyAccumulator(List list, int value) {
        this.list = list;
        this.value = value;
    }

    public class Node {
        int a;
        Operation o;

        public Node(int a, Operation o) {
            this.a = a;
            this.o = o;
        }
    }

    public void add(int a, Operation o) {
        list.add(new Node(a, o));
    }


    public void accumulateLazy() {
        for (Object ob : this.list)
            this.value = ((Node) ob).o.doOperation(this.value, ((Node) ob).a);
    }

    private int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        List list = new LinkList();
        LazyAccumulator lazAcc = new LazyAccumulator(list, 5);
        lazAcc.add(4, new Operation() {
            @Override
            int doOperation(int x, int y) {
                return x + y;
            }
        });
        lazAcc.add(-9, new Operation() {
            @Override
            int doOperation(int x, int y) {
                return x - y;
            }
        });
        lazAcc.accumulateLazy();
        System.out.println(lazAcc.getValue());

    }

}