package com.algolethms.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.io.File;

/**
 * @Author: Administrator
 * @Date: 2020/1/2 :13:31
 * @Description:
 */
public class SortCompare {

    /**
     * 排序参数
     */
    private static final String SELECTION = "Selection";
    private static final String INSERTION = "Insertion";
    private static final String SHELL = "Shell";
    private static final String MERGE = "Merge";
    private static final String MERGEBU = "MergeBu";
    private static final String QUICK = "Quick";
    private static final String HEAP = "Heap";

    /**
     * 获取运行时间
     * @param alg
     * @param a
     * @return
     */
    public static double time(String alg,Comparable[] a){
        System.out.print(Example.isSorted(a)+" ");
        long start = System.currentTimeMillis();
        if (alg.equals("Selection")){
            Selection selection = new Selection();
            selection.sort(a);
        };
        if (alg.equals("Insertion")){
            Insertion insertion = new Insertion();
            insertion.sort(a);
        };
        if ("Shell".equals(alg)){
            Shell shell = new Shell();
            shell.sort(a);
        };
        if (alg.equals("Merge")){
            Example merge = new com.algolethms.sort.Merge();
            merge.sort(a);
        };
        if (alg.equals("MergeBu")){
            Example merge = new com.algolethms.sort.Merge();
            merge.sort(a);
        };
        if (alg.equals("Quick")){
            Quick quick = new Quick();
            quick.sort(a);
        };
        if (alg.equals("Heap")){
            Heap heap = new Heap();
            heap.sort(a);
        };
        long duration = (System.currentTimeMillis() - start);
        System.out.print(Example.isSorted(a)+" ");
        return duration;
    }

    /**
     * 随机输入测试排序性能
     * @param alg 排序选择参数
     * @param N 数组大小
     * @param T 循环次数
     * @return
     */
    public static double timeRandomInput(String alg,int N,int T){
        double total = 0.0;
        Comparable[] comparables = new Comparable[N];
        for (int t = 0;t<T;t++){
            for (int i = 0;i<N;i++){
                comparables[i] = StdRandom.uniform(47);
            }
            total+=time(alg,comparables);
        }
        return total;
    }

    public static void main(String[] args) {
//        File tinyUF = new File("tinyUF.txt");
//        File mediumUF = new File("mediumUF.txt");
//        File largeUF = new File("largeUF.txt");
//        System.out.println(timeRandomInput(SortCompare.SELECTION, 100, 1)+"ms");
//        System.out.println(timeRandomInput(SortCompare.INSERTION, 100, 1)+"ms");
//        System.out.println(timeRandomInput(SortCompare.SHELL, 100, 1)+"ms");
//        System.out.println(timeRandomInput(SortCompare.MERGE, 39, 1)+"ms");
        System.out.println(timeRandomInput(SortCompare.MERGEBU, 100000000, 1)+"ms");
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(timeRandomInput(SortCompare.QUICK, 3900000, 1)+"ms");
        System.out.println(timeRandomInput(SortCompare.HEAP, 100000000, 1)+"ms");

    }
}
