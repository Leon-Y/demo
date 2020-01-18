package com.algolethms.search;


import edu.princeton.cs.algs4.Queue;

/**
 * @Author: Administrator
 * @Date: 2020/1/17 :14:02
 * @Description: 二分查找实现的map结构（防御性代码去除，数组越界会抛出异常）
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> extends STSorted<Key, Value> {

    /**
     * 键数组
     */
    private Key[] keys;

    /**
     * 值数组
     */
    private Value[] values;

    /**
     * 元素数量
     */
    private int N;

    public BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        return null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    Key min() {
        if (N > 0) {
            return keys[0];
        }
        return null;
    }

    @Override
    Key max() {
        if (N > 0) {
            return keys[N - 1];
        }
        return null;
    }

    @Override
    Key floor(Key key) {
        int rank = rank(key);
        if (rank < N && key.compareTo(keys[rank]) == 0) {
            return keys[rank];
        }
        return keys[rank];
    }

    @Override
    Key ceiling(Key key) {
        int rank = rank(key);
        return keys[rank];
    }

    @Override
    int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        int mid;
        int co;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            co = key.compareTo(keys[mid]);
            if (co > 0) {
                lo = mid + 1;
            } else if (co < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    Key select(int k) {
        if (N > 0) {
            return keys[k];
        }
        return null;
    }

    @Override
    Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> keyQueue = new Queue<>();
        for (int i = rank(lo); i <= rank(hi); i++) {
            keyQueue.enqueue(keys[i]);
        }
        return keyQueue;
    }

    @Override
    public void delete(Key key) {
        int rank = rank(key);
        if (rank < N && key.compareTo(keys[rank]) == 0) {
            for (int i = rank; i < N - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            keys[N - 1] = null;
            values[N - 1] = null;
            N--;
        }
    }
}
