package com.algolethms.chapter1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Administrator
 * @Date: 2019/10/18 :11:20
 * @Description:
 */
public class practice6 {
    public static void main(String[] args) {
        int f= 0;
        int g = 1;
        for (int i=0;i<=15;i++){
            StdOut.printf("f:%6d              g:%6d\n",f,g);
            f=f+g;
            g=f-g;
        }
        StdOut.printf("f:%dg:%d",f,g);
    }
}
