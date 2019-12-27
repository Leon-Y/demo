package com.algolethms.union;

/**
 * @Author: Administrator
 * @Date: 2019/12/27 :14:09
 * @Description: union-find算法的api
 */
public interface UF {
    /**
     * 在p和q之间添加一条链接
     * @param p
     * @param q
     */
    void union(int p,int q);

    /**
     * p(0到N-1之间)所在分量的标识符
     * @param p
     * @return
     */
    int find(int p);

    /**
     * 如果p和q之间存在同一个分量中，则返回true
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p,int q);

    /**
     * 连通分量的数量
     * @return
     */
    int count();
}
