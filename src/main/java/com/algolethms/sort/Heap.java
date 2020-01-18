package com.algolethms.sort;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Administrator
 * @Date: 2020/1/11 :16:30
 * @Description: 堆排序
 */
public class Heap extends Example {
    @Override
    public void sort(Comparable[] comparables) {
        int N = comparables.length - 1;
        for (int i = N / 2; i >= 0; i--) {
            sink(comparables, i, N);
        }
        while (N > 0) {
            exch(comparables, 0, N--);
            sink(comparables, 0, N);
        }
//        List<Comparable> comparables1 = Arrays.asList(comparables);
//        System.out.println(comparables1);
    }
}
