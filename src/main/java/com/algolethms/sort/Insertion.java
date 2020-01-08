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
            for (int j = i; j > 0&&(less(comparables[j],comparables[j-1])); j--) {
                    exch(comparables,j,j-1);
            }
        }
    }


}
