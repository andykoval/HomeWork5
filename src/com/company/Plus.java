package com.company;

/**
 * Created by andy on 22.10.2017.
 */
public class Plus extends Operation

{
//    Plus(int x, int y) {
//        super(x, y);
//    }

    @Override
    int doOperation(int x, int y) {
        result = x + y;
        return result;
    }
}
