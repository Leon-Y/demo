package com.javaconcurrencypractice.concurrentTest;

import junit.framework.TestCase;

/**
 * @Auther: 36560
 * @Date: 2020/2/6 :10:25
 * @Description:
 */
public class BounderBufferTest extends TestCase {
//    单线程测试
    public void testIfEmptyWhenConstracted() {
        BoundedBuffer<Integer> integerBoundedBuffer = new BoundedBuffer<>(10);
        assertTrue(integerBoundedBuffer.isEmpty());
        assertFalse(integerBoundedBuffer.isFull());
    }
//  单线程添加测试
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> integerBoundedBuffer = new BoundedBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            integerBoundedBuffer.put(i);
        }
        assertFalse(integerBoundedBuffer.isEmpty());
        assertTrue(integerBoundedBuffer.isFull());
    }

    public void testBlockWhenEmpty(){
        BoundedBuffer<Integer> integerBoundedBuffer = new BoundedBuffer<>(10);
        Thread thread = new Thread() {
            public void run() {
                try {
                    int unused = integerBoundedBuffer.take();
                    fail();//如果执行到这里则会存在一个错误
                } catch (InterruptedException e) {
                    System.out.println("线程中断");
                }
            }
        };
        try {
            thread.start();
            Thread.sleep(1000);
            System.out.println("发出中断信号");
            thread.interrupt();
            thread.join(1000);
            assertFalse(thread.isAlive());
        } catch (Exception e) {
            fail();
        }
    }
}

