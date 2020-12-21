package com.javaconcurrencypractice;

/**
 * @Auther: 36560
 * @Date: 2020/2/3 :8:22
 * @Description:
 */
class LiftOff implements Runnable {


    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}

public class MainThread{
    public static void main(String[] args) {
        MainThread mainThread = new MainThread();
        mainThread.test();
    }
    public void test(){
        Thread t = new Thread(new LiftOff(10000));
        t.start();
        t.setName("lift off thread");
        System.out.println("waiting for liftoff");
    }
}
