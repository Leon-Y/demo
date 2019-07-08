package com.example.templete;

/**
 * @Author: Xiao
 * @Date: 2019/6/27 :8:41
 * @Description:
 */
public abstract class Event {
    private long delayTime ;
    private long startTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        startTime = System.nanoTime() + delayTime;
    }
    public boolean reday(){
        return startTime <= System.nanoTime();
    }
    public void start(){
        startTime = System.nanoTime() + delayTime;
    }
    public abstract void action();
}
