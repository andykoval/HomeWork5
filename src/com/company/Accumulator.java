package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class Accumulator {
    private int value, valueAcc;
    private Operation oper;

    Accumulator(int value, Operation oper) {
        this.oper = oper;
        this.value = value;
    }

    public void accumulate(int valueAcc) {
        this.valueAcc = valueAcc;
    }

    public int getValue() {
        return oper.doOperation(value, valueAcc);
    }

    public static void main(String[] args) {
        Accumulator acc1 = new Accumulator(3, new Power());
        acc1.accumulate(4);
        System.out.println("Power result: " + acc1.getValue());

        Accumulator acc2 = new Accumulator(5, new Plus());
        acc2.accumulate(9);
        System.out.println("Plus result: " + acc2.getValue());

        Accumulator acc3 = new Accumulator(20, new Divide());
        acc3.accumulate(5);
        System.out.println("Divide result: " + acc3.getValue());

        Accumulator acc4 = new Accumulator(5987, new Minus());
        acc4.accumulate(1298);
        System.out.println("Minus result: " + acc4.getValue());

        Accumulator acc5 = new Accumulator(44, new Multiply());
        acc5.accumulate(11);
        System.out.println("Multiply result: " + acc5.getValue());


    }

}
