package com.algolethms.sort;

import java.util.Arrays;
import java.util.Random;

public class CSort {
    private static Random random = new Random();

    public static void main(String[] args) {
        int[] arrays = fill(1000000);
//        isort(arrays);
        shellsort(arrays);
        mergeSort(arrays);
        quickSort(arrays);
    }

    private static int[] fill(int number) {
        int[] arrays = new int[number];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = random.nextInt(number);
        }
        return arrays;
    }

    /**
     * 插入排序
     *
     * @param arraysO arrays
     */
    private static void isort(int[] arraysO) {
        int[] arrays = Arrays.copyOf(arraysO, arraysO.length);

        Long beginTime = System.currentTimeMillis();
        for (int i = 0; i < arrays.length; i++) {
            int tmp = arrays[i];
            int j = i - 1;

            boolean isChange = false;
            while (j >= 0 && arrays[j] > tmp) {
                arrays[j + 1] = arrays[j];
                j--;
                isChange = true;
            }

            if (isChange) {
                arrays[j + 1] = tmp;
            }

        }

        System.out.println("isort time " + (System.currentTimeMillis() - beginTime) * 1.0 / 1000);
//        System.out.println("isort result " + Arrays.toString(arrays));

    }

    /**
     * 希尔排序 递增数列为n方(n2)
     *
     * @param arraysO arrays
     */
    private static void shellsort(int[] arraysO){
        int[] arrays = Arrays.copyOf(arraysO, arraysO.length);
        Long beginTime = System.currentTimeMillis();
        int step = arrays.length / 2;
        while(step != 0){
            subShellsort(arrays, step);
            step = step / 2;
        }
        System.out.println("shell time " + (System.currentTimeMillis() - beginTime) * 1.0 / 1000);
//        System.out.println("isort result " + Arrays.toString(arrays));

    }

    private static void subShellsort(int[] arrays, int step){
        int length = arrays.length;
        for (int k = 0; k < step; k++) {
            for (int i = k; i < length; i+=step) {
                int tmp = arrays[i];
                int j = i - step;

                boolean isChange = false;
                while(j >= 0  && tmp < arrays[j]){
                    arrays[j + step] = arrays[j];
                    j -= step;
                    isChange = true;
                }
                if(isChange){
                    arrays[j + step] = tmp;
                }
            }

        }
    }

    /**
     * 快速排序
     *
     * @param arraysO arrays
     */
    private static void quickSort(int[] arraysO){
        int[] arrays = Arrays.copyOf(arraysO, arraysO.length);
        Long beginTime = System.currentTimeMillis();
        subQuicksort(arrays, 0, arrays.length - 1);
        System.out.println("quick time " + (System.currentTimeMillis() - beginTime) * 1.0 / 1000);
//        System.out.println("isort result " + Arrays.toString(arrays));
    }

    private static void subQuicksort(int[] arrays, int begin, int end){
        if(begin >= end){
            return;
        }

        int pivot = arrays[(end - begin) / 2 + 1 + begin];
        int i = begin, j = end;

        while(i < j){
            while(arrays[i] < pivot){
                i++;
            }

            while(arrays[j] > pivot){
                j--;
            }
            if(i < j){
                int tmp = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = tmp;
                i++;
                j--;
            }
        }
        if(i == j){
            j--;
        }

        subQuicksort(arrays, begin, j);
        subQuicksort(arrays, i, end);
    }

    /**
     * 归并排序
     *
     * @param arraysO arrays
     */
    private static void mergeSort(int[] arraysO){
        int[] arrays = Arrays.copyOf(arraysO, arraysO.length);
        int[] mergeArrays = new int[arrays.length];
        Long beginTime = System.currentTimeMillis();
        subMergeSort(arrays, mergeArrays,0, arrays.length);
        System.out.println("merge time " + (System.currentTimeMillis() - beginTime) * 1.0 / 1000);
//        System.out.println("isort result " + Arrays.toString(arrays));

    }

    private static void subMergeSort(int[] arrays, int[] mergeArrays, int begin, int end){
        if(begin == end){
            return;
        }
        int mid = (end - begin) / 2  + begin;

        int begin1 = begin;
        int end1 = mid;

        int begin2 = mid + 1;
        int end2 = end;

        subMergeSort(arrays, mergeArrays, begin1, end1);
        subMergeSort(arrays, mergeArrays, begin2, end2);


        int k=0;
        while(begin1 <= end1 && begin2 < arrays.length && begin2 <= end2){
            mergeArrays[k++] = arrays[begin1] < arrays[begin2] ? arrays[begin1++] :  arrays[begin2++];
        }

        while(begin1 <= end1 && begin1 < arrays.length){
            mergeArrays[k++] = arrays[begin1++];
        }

        while(begin2 <= end2 && begin2 < arrays.length){
            mergeArrays[k++] = arrays[begin2++];
        }

        for (int i = 0; i < k; i++) {
            arrays[begin + i] = mergeArrays[i];
        }
    }
}