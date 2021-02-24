package ru.geekbrains.interview_preparation.hw1.task3.classes;

import ru.geekbrains.interview_preparation.hw1.task3.interfaces.Measurable;
import ru.geekbrains.interview_preparation.hw1.task3.interfaces.Moveable;

public class Circle implements Measurable, Moveable {
    private double Radius;
    private double x;
    private double y;

    @Override
    public double getArea() {
        return Math.PI * Math.pow(Radius, 2);
    }

    @Override
    public void move(double x, double y) {
        System.out.println("moving this Circle");
        this.x += x;
        this.y += y;
    }
}
