package com.algolethms.union;

/**
 * @Author: Administrator
 * @Date: 2019/12/27 :14:14
 * @Description:
 */
public class QuickFind implements UF {

    /**
     * 触点的标记
     */
    private int[] id;
    /**
     * 分量数量
     */
    private int count;

    /**
     * 初始化触点的数量
     *
     * @param N
     */
    public QuickFind(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        //如果已经是同一个分量则不需要处理
        if (pId == qId) {
            return;
        }
        //将所有的p分量命名为q分量
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId){
                id[i] = qId;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
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
