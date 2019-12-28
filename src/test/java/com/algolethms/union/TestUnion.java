package com.algolethms.union;


import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * @Author: Administrator
 * @Date: 2019/12/27 :15:10
 * @Description:
 */
public class TestUnion {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

    }

    @Test
    public void findTest() {
        File tinyUF = new File(this.getClass().getClassLoader().getResource("tinyUF.txt").getPath());
        File mediumUF = new File(this.getClass().getClassLoader().getResource("mediumUF.txt").getPath());
        File largeUF = new File(this.getClass().getClassLoader().getResource("largeUF.txt").getPath());
        fileTest(QuickFind.class, tinyUF);
        fileTest(QuickFind.class, mediumUF);
        fileTest(QuickFind.class, largeUF);
    }

    @Test
    public void path() {
        File tinyUF = new File("tinyUF.txt");
        String path = tinyUF.getPath();
        System.out.println(path);
        String absolutePath = tinyUF.getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(this.getClass().getResource("../").getPath());
        System.out.println(this.getClass().getClassLoader().getResource(""));
        System.out.println(this.getClass().getClassLoader().getResource("/"));
        System.out.println(this.getClass().getClassLoader().getResource("tinyUF.txt").getPath());
    }

    @Test
    public void unionTest() {
        File tinyUF = new File(this.getClass().getClassLoader().getResource("tinyUF.txt").getPath());
        File mediumUF = new File(this.getClass().getClassLoader().getResource("mediumUF.txt").getPath());
        File largeUF = new File(this.getClass().getClassLoader().getResource("largeUF.txt").getPath());
        fileTest(UnionFind.class, tinyUF);
        fileTest(UnionFind.class, mediumUF);
        fileTest(UnionFind.class, largeUF);
    }

    @Test
    public void weightUnionTest() {
        File tinyUF = new File(this.getClass().getClassLoader().getResource("tinyUF.txt").getPath());
        File mediumUF = new File(this.getClass().getClassLoader().getResource("mediumUF.txt").getPath());
        File largeUF = new File(this.getClass().getClassLoader().getResource("largeUF.txt").getPath());
        fileTest(WeightQuickUnion.class, tinyUF);
        fileTest(WeightQuickUnion.class, mediumUF);
        fileTest(WeightQuickUnion.class, largeUF);
    }

    /**
     * @param clazz
     * @param file
     */
    public void fileTest(Class<? extends UF> clazz, File file) {
        long start = System.currentTimeMillis();
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            String next = scanner.next();
            Constructor<? extends UF>[] declaredConstructors = (Constructor<? extends UF>[]) clazz.getDeclaredConstructors();
            Constructor<? extends UF> declaredConstructor = declaredConstructors[0];
            Object[] paramters = new Object[]{Integer.valueOf(next)};
            UF instance = declaredConstructor.newInstance(paramters);
            while (scanner.hasNext()) {
                instance.union(Integer.valueOf(scanner.next()), Integer.valueOf(scanner.next()));
            }
//            for (int i = 0; i < instance.getId().length; i++) {
//                System.out.format("%d%s", instance.getId()[i], " ");
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("\n"+"用时："+((System.currentTimeMillis() - start) )+"ms");
    }
}
