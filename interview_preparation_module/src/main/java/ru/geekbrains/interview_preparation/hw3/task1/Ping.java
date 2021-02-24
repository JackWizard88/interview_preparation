package ru.geekbrains.interview_preparation.hw3.task1;

import java.util.concurrent.locks.Lock;

public class Ping implements Runnable {

    Lock lock;

    public Ping(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while(true) {
                try {
                    System.out.println("PING____    ");
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
