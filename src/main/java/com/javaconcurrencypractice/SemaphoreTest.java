package com.javaconcurrencypractice;

import java.util.concurrent.Semaphore;

/**
 * @Auther: 36560
 * @Date: 2020/2/5 :16:08
 * @Description:
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
