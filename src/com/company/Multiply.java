package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class Multiply extends Operation {
//    Multiply(int x, int y) {
//        super(x, y);
//    }

    @Override
    int doOperation(int x, int y) {
        result = x * y;
        return result;
    }
}
