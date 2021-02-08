package ru.geekbrains.interveiw_preparation.hw3.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private long count = 0;
    private final Lock lock = new ReentrantLock();

    public long getCount() {
        return count;
    }

    public void count() {
        lock.lock();
        count++;
        if (count % 1000 == 0) {
            System.err.println("count = " + count);
        }
        lock.unlock();
    }

    public void reset() {
        lock.lock();
        count = 0;
        lock.unlock();
    }
}
