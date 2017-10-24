package com.company;

/**
 * Created by andy on 21.10.2017.
 */
public abstract class Form implements Shape {
    double x1, y1, x2, y2, sideX, sideY, sideZ, rad, perimetr, area;
    public final double PI = 3.14159265;

    public Form(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getSideX() {
        return sideX;
    }

    public double getSideY() {
        return sideY;
    }

    public double getSideZ() {
        return sideZ;
    }

    public double getRad() {
        return rad;
    }

    public double getPerim() {
        return perimetr;
    }

    public double getArea() {
        return area;
    }
}


