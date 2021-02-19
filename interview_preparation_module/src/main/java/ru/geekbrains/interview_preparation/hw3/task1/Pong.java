package ru.geekbrains.interview_preparation.hw3.task1;

import java.util.concurrent.locks.Lock;

public class Pong implements Runnable {

    Lock lock;

    public Pong(Lock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while(true) {
                try {
                    System.out.println("    ____PONG");
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
