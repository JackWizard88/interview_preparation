package ru.geekbrains.interveiw_preparation.hw1.task3.classes;

import ru.geekbrains.interveiw_preparation.hw1.task3.interfaces.Measurable;
import ru.geekbrains.interveiw_preparation.hw1.task3.interfaces.Moveable;

public class Square implements Measurable, Moveable {
    private double SideLength;
    private double x;
    private double y;

    @Override
    public double getArea() {
        return Math.pow(SideLength, 2);
    }

    @Override
    public void move(double x, double y) {
        System.out.println("moving this Square");
        this.x += x;
        this.y += y;
    }
}
