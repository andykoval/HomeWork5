package com.company;

/**
 * Создается прямоугольник принимающий 2 координаты
 */

public class Restangle extends Form{

    public Restangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public double getSideX() {
        sideX = Math.abs(x1 - x2);
        return sideX;
    }

    public double getSideY() {
        sideY = Math.abs(y1 - y2);
        return sideY;
    }

    public double getPerim() {
        perimetr = (getSideX() + getSideY()) * 2;
        return perimetr;
    }

    public double getArea() {
        area = getSideX() * getSideY();
        return area;
    }
}
