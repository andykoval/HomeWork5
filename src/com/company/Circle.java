package com.company;

/**
 * Создается круг принимающий координаты центра и точки на окружности
 */

public class Circle extends Form {
    double rad;

    public Circle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public double getSideX() {
        sideX = Math.abs(x1 - x2);
        return sideX;
    }

    @Override
    public double getSideY() {
        sideY = Math.abs(y1 - y2);
        return sideY;
    }

    @Override
    public double getRad() {
        rad = Math.sqrt(getSideX() * getSideX() + getSideY() * getSideY());
        return rad;
    }

    @Override
    public double getPerim() {
        perimetr = 2 * PI * getRad();
        return perimetr;
    }

    @Override
    public double getArea() {
        area = PI * (getRad() * getRad());
        return area;
    }
}
