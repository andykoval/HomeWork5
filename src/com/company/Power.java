package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class Power extends Operation {
//    Power(int x, int y) {
//        super(x, y);
//    }

    @Override
    int doOperation(int x, int y) {
        result = (int) Math.pow(x, y);
        return result;
    }
}
