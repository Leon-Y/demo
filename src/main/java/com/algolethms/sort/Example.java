package com.algolethms.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import jdk.jfr.events.SocketReadEvent;

import java.util.concurrent.ConcurrentMap;

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

//        drawSort(a);
//        StdDraw.clear();
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
     *
     * @param a
     * @return
     */
    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[1 - 1])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序动画
     *
     * @param a
     */
    public static void drawSort(Comparable[] a) {
        StdDraw.setXscale(-1, a.length + 1);

        Comparable max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (less(max, a[i])) {
                max = a[i];
            }
        }
        StdDraw.setYscale(-2, (Double) max + 1);

        for (int i = 0; i < a.length; i++) {
            double y = (Double) a[i];
            StdDraw.filledRectangle(i + 0.5, y / 2.0, 0.3, y / 2.0);
        }
//        StdDraw.pause(100);
    }

    /**
     * 归并所需的辅助数组
     */
    protected static Comparable[] aux;

    /**
     * 合并数组
     */
    public static void merge(Comparable[] comparables, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = comparables[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                comparables[k] = aux[j++];
            } else if (j > hi) {
                comparables[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                comparables[k] = aux[j++];
            } else {
                comparables[k] = aux[i++];
            }
        }
    }

    /**
     * 快速排序的切分
     *
     * @param comparables
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] comparables, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        Comparable loValue = comparables[lo];
        while (true) {
            while (i < hi && less(comparables[i], loValue)) {
                i++;
            }
            while (j > lo && !less(comparables[j], loValue)) {
                j--;
            }
            if (i < j) {
                exch(comparables, i, j);
            } else {
                break;
            }
        }
        exch(comparables, lo, j);
        return j;
    }

    /**
     * 堆的上浮(从hi浮至lo)
     *
     * @param comparables
     * @param lo          低位
     * @param hi          高位
     */
    public static void swim(Comparable[] comparables, int lo, int hi) {
        int k = hi - lo + 1;
        while (k > 1 && less(lo - 1 + k / 2, hi)) {
            exch(comparables, lo - 1 + k / 2, hi);
            k = lo - 1 + k / 2;
        }
    }

    /**
     * 堆的下沉(从lo下沉至hi)
     *
     * @param comparables
     * @param k           下沉的元素位置
     * @param N           下沉的深度
     */
    public static void sink(Comparable[] comparables, int k, int N) {
        k = k + 1;
        N = N + 1;
        int j;
        while (2 * k <= N) {
            j = 2 * k;
            if (j < N && less(comparables[j - 1], comparables[j])) {
                j++;
            }
            if (less(comparables[j - 1], comparables[k - 1])) {
                break;
            }
            exch(comparables, k - 1, j - 1);
            k = j;
        }
    }
}
