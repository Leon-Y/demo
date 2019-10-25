package com.algolethms.chapter1;

import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Administrator
 * @Date: 2019/10/18 :13:39
 * @Description:
 */
public class Practice13 {
    public static void main(String[] args) {
        int[][] MN = {
                {1,2,3,4,5,6,7,8,0},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {1,2,3,4,5,6,7,8,9},
                {9,2,3,4,5,6,7,8,9},
        };
        for (int i = 0; i< MN.length;i++){
            for (int j=0;j<MN[i].length;j++){
                StdOut.print(MN[j][i]+" ");
            }
            StdOut.println();
        }
    }
}
