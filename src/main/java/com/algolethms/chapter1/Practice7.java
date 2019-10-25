package com.algolethms.chapter1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Administrator
 * @Date: 2019/10/18 :11:28
 * @Description:
 */
public class Practice7 {
    public static void main(String[] args) {
        //a
        double t = 9.0;
        while (Math.abs(t-9.0/t) > .001){
            t=(9.0/t + t)/2.0;
        }
        StdOut.printf("%.5f\n",t);
        //b
        int sum = 0;
        for (int i=0;i<1000;i++){
            sum++;
        }
        StdOut.println(sum);
        //c
        int sum2 = 0;
        for (int i =1;i<1000;i*=2){
            for (int j = 0;j<1000;j++){
                sum2++;
            }
        }
        StdOut.println(sum2);

    }
}
