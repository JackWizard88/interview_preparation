package ru.geekbrains.interview_preparation.hw3;

import ru.geekbrains.interview_preparation.hw3.task1.Ping;
import ru.geekbrains.interview_preparation.hw3.task1.Pong;
import ru.geekbrains.interview_preparation.hw3.task2.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main3 {

    public static void main(String[] args) throws InterruptedException {

        // Задание 1: Реализовать программу, в которой два потока поочередно пишут ping и pong.
//        testPingPong();

        // Задание 2: Реализовать потокобезопасный счетчик с помощью интерфейса Lock.
        // Запускает 7 потоков. В результате должен вывести число 6550
        testCounter();

    }

    private static void testCounter() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Counter counter = new Counter();

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.count();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.count();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.count();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.count();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.count();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.count();
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 550; i++) {
                counter.count();
            }
        });

        Thread.sleep(5000);
        System.err.println("summary score = " + counter.getCount());

        executorService.shutdown();
    }

    private static void testPingPong() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Lock lock = new ReentrantLock();

        Ping ping = new Ping(lock);
        Pong pong = new Pong(lock);

        executorService.submit(ping);
        executorService.submit(pong);

        executorService.shutdown();
    }
}
