package com.javaconcurrencypractice.concurrentTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: 36560
 * @Date: 2020/2/6 :11:03
 * @Description:
 */
public class putTakeTest {
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private final AtomicInteger putSum = new AtomicInteger();
    private final AtomicInteger takeSum = new AtomicInteger();
    private final CyclicBarrier barrier;
    private final BoundedBuffer<Integer> boundedBuffer;
    private int nPairs, nTrials;

    public static void main(String[] args) {
        putTakeTest putTakeTest = new putTakeTest(10, 10, 10000);
        putTakeTest.test();
        pool.shutdown();
    }

    public putTakeTest(int capacity, int nPairs, int nTrials) {
        this.nPairs = nPairs;
        this.nTrials = nTrials;
        this.barrier = new CyclicBarrier(nPairs * 2 + 1);
        this.boundedBuffer = new BoundedBuffer<>(capacity);
    }

    void test() {
        try {
            for (int i = 0; i < nPairs; i++) {
                pool.execute(new Producer());
                pool.execute(new Consumer());
            }
            barrier.await();
            barrier.await();
            System.out.println("校验和是否相等：" + (putSum.get() == takeSum.get()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    static int xorShift(int y) {
        y ^= y << 6;
        y ^= y >>> 21;
        y ^= y << 7;
        return y;
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            try {
                int seed = this.hashCode() ^ (int) System.currentTimeMillis();
                int sum = 0;
                barrier.await();
                for (int i = nTrials; i > 0; i--) {
                    boundedBuffer.put(seed);
                    sum += seed;
                    seed = xorShift(seed);
                }
                putSum.getAndAdd(sum);
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                barrier.await();
                int sum = 0;
                for (int i = nTrials; i > 0; i--) {
                    sum += boundedBuffer.take();
                }
                takeSum.getAndAdd(sum);
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
