package com.algolethms.chapter1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Administrator
 * @Date: 2019/10/18 :13:33
 * @Description:二进制处理
 */
public class Practice9 {
    public static void main(String[] args) {
        int N = 2658;
        String s = "";
        for (int n = N ;n > 0;n/=2){
            s+=n%2;
        }
        StdOut.println(s);
    }
}
