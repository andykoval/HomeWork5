package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class Accumulator {
    private int value;
    private Operation oper;

    public Accumulator(int value, Operation oper) {
        this.oper = oper;
        this.value = value;
    }

    private void accumulate(int arg) {

        value = oper.doOperation(value, arg);
    }

    private int getValue() {

        return value;
    }

    public static void main(String[] args) {
        Operation p = new Power(){
            @Override
            int doOperation(int x, int y) {
                System.out.println("I can owerride this!!");
                result = (int) Math.pow(x, y+10);
                return result;
            }
        };
        Operation d = new Divide(){
            @Override
            int doOperation(int x, int y) {
                System.out.println("And this!");
                result = x / y;
                return result;
            }
        };
//
        Accumulator acc1 = new Accumulator(3, p);
        acc1.accumulate(4);
        System.out.println("Power result: " + acc1.getValue());

        Accumulator acc2 = new Accumulator(5, new Plus());
        acc2.accumulate(9);
        System.out.println("Plus result: " + acc2.getValue());

        Accumulator acc3 = new Accumulator(20, d);
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
