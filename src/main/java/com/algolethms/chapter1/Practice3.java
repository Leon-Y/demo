package com.algolethms.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @Author: Administrator
 * @Date: 2019/10/18 :10:53
 * @Description:
 */
public class Practice3 {
    public static void main(String[] args) {
        args = new String[]{"2","2","2"};
        if (args.length == 3){
            if (Integer.parseInt(args[0]) == Integer.parseInt(args[1]) && Integer.parseInt(args[1]) == Integer.parseInt(args[2])){
                StdOut.println("equal");
            }else {
                StdOut.println("not equal");
            }
        }
    }
}
