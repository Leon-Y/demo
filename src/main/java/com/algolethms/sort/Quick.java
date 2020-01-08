package com.algolethms.sort;

/**
 * @Author: Administrator
 * @Date: 2020/1/8 :13:27
 * @Description:
 */
public class Quick extends Example {

    @Override
    public void sort(Comparable[] comparables) {
        sort(comparables, 0, comparables.length - 1);
    }

    /**
     * 快速排序递归
     *
     * @param comparables
     * @param lo
     * @param hi
     */
    public void sort(Comparable[] comparables, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(comparables, lo, hi);
        sort(comparables, lo, j);
        sort(comparables, j + 1, hi);
    }
}
