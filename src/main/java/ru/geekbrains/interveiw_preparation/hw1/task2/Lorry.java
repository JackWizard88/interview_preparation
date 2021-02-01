package ru.geekbrains.interveiw_preparation.hw1.task2;

public class Lorry extends Car {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void move() {
        System.out.println("Lorry is moving");
    }

    @Override
    public void stop() {
        System.out.println("Lorry is stopping");
    }
}
