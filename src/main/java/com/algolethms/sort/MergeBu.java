package com.algolethms.sort;

/**
 * @Author: Administrator
 * @Date: 2020/1/7 :14:12
 * @Description:
 */
public class MergeBu extends Example {

    /**
     * 自下向上的归并排序
     *
     * @param comparables
     */
    @Override
    public void sort(Comparable[] comparables) {
        int N = comparables.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo = sz + sz) {
                merge(comparables, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N));
            }
        }
    }
}
