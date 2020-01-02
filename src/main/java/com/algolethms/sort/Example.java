package com.algolethms.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import jdk.jfr.events.SocketReadEvent;

/**
 * @Author: Administrator
 * @Date: 2019/12/31 :10:48
 * @Description:
 */
public abstract class Example {

    /**
     * 排序方法
     */
    public abstract void sort(Comparable[] comparables);

    /**
     * 比较大小，a<b true a>b false
     *
     * @param a
     * @param b
     * @return
     */
    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换内容
     *
     * @param a
     * @param i
     * @param j
     */
    protected static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * .
     * 打印数组
     *
     * @param a
     */
    protected static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    /**
     * 检查是否排序正确，对于主键完全相同的数组无效
     * @param a
     * @return
     */
    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[1-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = In.readStrings();
        show(strings);
    }
}
