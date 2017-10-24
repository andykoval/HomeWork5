package com.company;

/**
 * Создать фигуры: Circle, Rectangle, Triangle, у которых будут координаты.
 * Все фигуры должны иметь методы, которые возвращают площадь и периметр (для окружности - длина окружности)
 */

public class Figure {
    public static void main(String[] args) {
        Restangle res = new Restangle(3, 5, -4, -2);
        System.out.println("Периметр прямоугольника с длинами сторон: " + res.getSideX() + " и " + res.getSideY() + " равна " + res.getPerim());
        System.out.println("Площадь прямоугольника с длинами сторон: " + res.getSideX() + " и " + res.getSideY() + " равна " + res.getArea());
        Triangle tri = new Triangle(6, 7, 2, 4);
        System.out.println("Периметр треугольника с длинами сторон: " + tri.getSideX() + " и " + tri.getSideY() + " равен " + tri.getPerim());
        System.out.println("Площадь треугольника с длинами сторон: " + tri.getSideX() + " и " + tri.getSideY() + " равна " + tri.getArea());
        Circle cir = new Circle(6, 7, 2, 4);
        System.out.println("Периметр круга с радиусом " + cir.getRad() + " равен " + cir.getPerim());
        System.out.println("Площадь круга с радиусом " + cir.getRad() + " равна " + cir.getArea());
    }
}
