package com.algolethms.sort;

/**
 * @Author: Administrator
 * @Date: 2020/1/2 :10:15
 * @Description: 希尔排序
 */
public class Shell extends Example {
    @Override
    public void sort(Comparable[] comparables) {
        /**
         * 常数因子，最小值为1
         */
        int h = 1;
        int N = comparables.length;
        while (h < N / 3) {
            //1、4、13、40、121、364、1093
            h = 3 * h + 1;
        }
        while(h>=1){
            for (int i = h;i< N;i++){
                for (int j=i;j>=h&&(less(comparables[j],comparables[j-h]));j-=h){
                        exch(comparables,j,j-h);
                }
            }
            h=h/3;
        }
    }
}
