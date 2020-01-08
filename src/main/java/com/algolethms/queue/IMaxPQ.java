package com.algolethms.queue;

/**
 * @Author: Administrator
 * @Date: 2020/1/8 :16:13
 * @Description:
 */
public interface IMaxPQ<Key extends Comparable<Key>> {
    /**
     * 插入方法
     * @param key
     */
    void insert(Key key);

    /**
     * 返回最大值
     * @return
     */
    Key max();

    /**
     * 删除最大值
     * @return
     */
    Key delMax();

    /**
     * 是否空队列
     * @return
     */
    boolean isEmpty();

    /**
     * 返回队列大小
     * @return
     */
    int size();
}
