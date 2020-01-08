package com.algolethms.sort;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @Author: Administrator
 * @Date: 2020/1/2 :16:04
 * @Description:
 */
public class ShellTest {

    @Test
    public void sort() {
        File tinyUF = new File(this.getClass().getClassLoader().getResource("tinyUF.txt").getPath());
        File mediumUF = new File(this.getClass().getClassLoader().getResource("mediumUF.txt").getPath());
        File largeUF = new File(this.getClass().getClassLoader().getResource("largeUF.txt").getPath());
        Shell shell = new Shell();
        In in = new In(largeUF);
        shell.sort(in.readAllStrings());
    }
}