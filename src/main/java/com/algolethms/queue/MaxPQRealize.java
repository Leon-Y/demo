package com.algolethms.queue;

/**
 * @Author: Administrator
 * @Date: 2020/1/11 :16:40
 * @Description:
 */
public class MaxPQRealize<Key extends Comparable<Key>> extends MaxPQ<Key> {


    public MaxPQRealize() {
        this(DEFAULT_SIZE, DEFAULT_FACTOR);
    }

    public MaxPQRealize(int max) {
        this(max, DEFAULT_FACTOR);
    }

    public MaxPQRealize(double factor) {
        this(DEFAULT_SIZE, factor);
    }

    public MaxPQRealize(int max, double factor) {
        super(max, factor);
        comparables = (Key[]) new Object[N];
    }

    @Override
    public void insert(Key comparable) {
        int k = size + 1;
        if (k > N * 0.75) {
            resize(2 * N);
        }
        comparables[k] = comparable;
        swim(k);
        size++;
    }

    @Override
    public Key max() {
        if (size > 0) {
            return comparables[1];
        }
        return null;
    }

    @Override
    public Key delMax() {
        if (size > 0) {
            Key result = comparables[1];
            exch(1,size);
            //去除对象游离
            comparables[size] = null;
            sink(1);
            size--;
            //数组大小重置
            if (size < N * 0.25) {
                resize(N / 2);
            }
            return result;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public int size() {
        return size;
    }
}
