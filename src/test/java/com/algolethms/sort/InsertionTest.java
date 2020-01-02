package com.algolethms.sort;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @Author: Administrator
 * @Date: 2020/1/2 :9:52
 * @Description:
 */
public class InsertionTest {

    /**
     * 插入排序测试
     */
    @Test
    public void testInsertion() {
        File tinyUF = new File(this.getClass().getClassLoader().getResource("tinyUF.txt").getPath());
        File mediumUF = new File(this.getClass().getClassLoader().getResource("mediumUF.txt").getPath());
        File largeUF = new File(this.getClass().getClassLoader().getResource("largeUF.txt").getPath());
        In in = new In(mediumUF);
        String[] strings = in.readAllStrings();
        Insertion insertion = new Insertion();
        insertion.sort(strings);
        Insertion.show(strings);
        System.out.println(Insertion.isSorted(strings));
    }
}