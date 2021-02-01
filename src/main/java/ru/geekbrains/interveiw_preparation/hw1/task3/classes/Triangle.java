package ru.geekbrains.interveiw_preparation.hw1.task3.classes;

import ru.geekbrains.interveiw_preparation.hw1.task3.interfaces.Measurable;
import ru.geekbrains.interveiw_preparation.hw1.task3.interfaces.Moveable;

public class Triangle implements Measurable, Moveable {
    private double baseLength;
    private double height;
    private double x;
    private double y;

    @Override
    public double getArea() {
        return (baseLength * height)/2;
    }

    @Override
    public void move(double x, double y) {
        System.out.println("moving this Triangle");
        this.x += x;
        this.y += y;
    }
}
