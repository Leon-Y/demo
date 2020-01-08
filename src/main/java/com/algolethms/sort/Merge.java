package com.algolethms.sort;

import java.util.concurrent.ConcurrentMap;

/**
 * @Author: Administrator
 * @Date: 2020/1/6 :14:53
 * @Description:
 */
public class Merge extends Example {



    @Override
    public void sort(Comparable[] comparables) {
        aux = new Comparable[comparables.length];
        sort(comparables, 0, comparables.length - 1);
    }

    /**
     * 排序方法
     * 自上而下的归并排序
     * @param comparables
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] comparables, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(comparables,lo,mid);
        sort(comparables,mid+1,hi);
        merge(comparables,lo,mid,hi);
    }



}
