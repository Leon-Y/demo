package com.algolethms.sort;

/**
 * @Author: Administrator
 * @Date: 2019/12/31 :11:12
 * @Description:选择排序
 */
public class Selection extends Example {

    @Override
    public void sort(Comparable[] comparables) {
        int N = comparables.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(comparables[j], comparables[min])) {
                    min = j;
                }
                exch(comparables, i, min);
            }
        }
    }
}
