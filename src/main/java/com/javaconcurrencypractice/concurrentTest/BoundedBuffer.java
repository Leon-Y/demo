package com.javaconcurrencypractice.concurrentTest;

import java.util.concurrent.Semaphore;

/**
 * @Auther: 36560
 * @Date: 2020/2/6 :10:10
 * @Description:
 */
public class BoundedBuffer<E> {
    private final Semaphore availableItems, availableSpace;
    private final E[] item;
    private int putPosition = 0, takePosition = 0;

    public BoundedBuffer(int capacity) {
        availableItems = new Semaphore(0);
        availableSpace = new Semaphore(capacity);
        item = (E[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull() {
        return availableSpace.availablePermits() == 0;
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        item[i] = x;
        putPosition = (++i == item.length) ? 0 : i;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E e = item[i];
        item[i] = null;
        takePosition = (++i == item.length) ? 0 : i;
        return e;
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E e = doExtract();
        availableSpace.release();
        return e;
    }

    public void put(E x) throws InterruptedException {
        availableSpace.acquire();
        doInsert(x);
        availableItems.release();
    }
}
