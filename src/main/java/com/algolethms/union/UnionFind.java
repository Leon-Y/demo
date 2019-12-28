package com.algolethms.union;

/**
 * @Author: Administrator
 * @Date: 2019/12/27 :14:27
 * @Description: 森林树算法
 */
public class UnionFind implements UF {
    /**
     * 分量数量
     */
    private int count;
    /**
     * 触点标记
     */
    public int[] id;

    public UnionFind(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        id[p] = qId;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int[] getId() {
        return id;
    }
}
