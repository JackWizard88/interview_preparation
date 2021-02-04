package ru.geekbrains.interveiw_preparation.hw1.task3;

import ru.geekbrains.interveiw_preparation.hw1.task3.classes.Circle;
import ru.geekbrains.interveiw_preparation.hw1.task3.classes.Square;
import ru.geekbrains.interveiw_preparation.hw1.task3.interfaces.Moveable;

public class Task3Main {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();

        move(circle, 10.0, 10.0);
        move(square, 10.0, -10.0);

    }

    static void move(Moveable target, double x, double y) {
        target.move(x, y);
        System.out.println("moving done...");
    }
}
