package com.algolethms.sort;

import edu.princeton.cs.algs4.In;

/**
 * @Author: Administrator
 * @Date: 2019/12/31 :13:48
 * @Description: 插入排序
 */
public class Insertion extends Example {
    @Override
    public void sort(Comparable[] comparables) {
        int N = comparables.length;
        for (int i = 1; i < N; i++) {
            int min = i;
            for (int j = i; j > 0; j--) {
                if (less(comparables[min],comparables[j-1])){
                    exch(comparables,min,j-1);
                    min = j-1;
                }
            }
        }
    }

}
