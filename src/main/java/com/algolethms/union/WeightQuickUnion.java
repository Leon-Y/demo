package com.algolethms.union;

/**
 * @Author: Administrator
 * @Date: 2019/12/27 :14:36
 * @Description:加权森林树
 */
public class WeightQuickUnion implements UF {
    /**
     * 分量数量
     */
    private int count;
    /**
     * 触点标记
     */
    private int[] id;
    private int[] sz;

    public WeightQuickUnion(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        if (sz[p]>sz[q]){
            id[q] = pId;
            sz[p] += sz[q];
        }else {
            id[p] = qId;
            sz[q] += sz[p];
        }
    }

    @Override
    public int find(int p) {
        int pId = id[p];
        while (p != pId) {
            pId = id[pId];
        }
        return pId;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
