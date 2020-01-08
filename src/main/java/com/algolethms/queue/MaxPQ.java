package com.algolethms.queue;

/**
 * @Author: Administrator
 * @Date: 2020/1/8 :16:17
 * @Description:
 */
public abstract class MaxPQ<Key extends Comparable<Key>> implements IMaxPQ {

    /**
     * 队列大小
     */
    protected int size;

    MaxPQ() {
    }

    ;

    /**
     * 指定队列大小
     *
     * @param max
     */
    MaxPQ(int max) {
        this.size = max;
    }

    ;
}
