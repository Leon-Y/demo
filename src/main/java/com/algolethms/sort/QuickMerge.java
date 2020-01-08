package com.algolethms.sort;

/**
 * @Author: Administrator
 * @Date: 2020/1/8 :9:25
 * @Description:
 */
public class QuickMerge extends Example {

    @Override
    public void sort(Comparable[] comparables) {
        aux = new Comparable[comparables.length];
        sort(comparables, 0, comparables.length - 1);
    }

    /**
     * @param comparables
     * @param lo
     * @param hi
     */
    private void sort(Comparable[] comparables, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(comparables, lo, mid);
        sort(comparables, mid + 1, hi);
        quickMerge(comparables, lo, mid, hi);
    }

    /**
     * 快速合并方法
     *
     * @param comparables
     * @param lo
     * @param mid
     * @param hi
     */
    private static void quickMerge(Comparable[] comparables, int lo, int mid, int hi) {
        for (int i = mid + 1; i <= hi; i++) {
            aux[i] = comparables[i];
        }

    }
}
