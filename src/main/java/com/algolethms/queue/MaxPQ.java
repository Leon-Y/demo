package com.algolethms.queue;

/**
 * @Author: Administrator
 * @Date: 2020/1/8 :16:17
 * @Description:
 */
public abstract class MaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key> {

    /**
     * 队列大小
     */
    protected int size;

    /**
     * 基本的数据存储
     */
    protected Key[] comparables;

    /**
     * 数组大小
     */
    protected int N = 0;

    /**
     * 数组的变长因数
     */
    protected final double FACTOR;

    /**
     * 默认的存储大小
     */
    protected final static int DEFAULT_SIZE = 16;

    /**
     * 默认的变长系数
     */
    protected final static double DEFAULT_FACTOR = 0.75;

    protected MaxPQ(int max, double factor) {
        N = max;
        FACTOR = factor;
        size = 0;
    }

    /**
     * 比较大小
     *
     * @param i
     * @param j
     */
    protected boolean less(int i, int j) {
        return comparables[i].compareTo(comparables[j]) < 0;
    }

    /**
     * 交换元素位置
     *
     * @param i
     * @param j
     */
    protected void exch(int i, int j) {
        Key comparable = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = comparable;
    }

    /**
     * 结构上浮
     *
     * @param k
     */
    protected void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 结构下沉
     *
     * @param k
     */
    protected void sink(int k) {
        int j;
        while (2 * k <= N) {
            j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * 数组扩容
     *
     * @param max
     */
    protected void resize(int max) {
        Key[] keys = (Key[]) new Object[max];
        int j = max < N ? max : N;
        for (int i = 0; i < j; i++) {
            keys[i] = comparables[i];
        }
        N = max;
        comparables = keys;
    }
}
