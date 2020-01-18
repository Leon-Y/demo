package com.algolethms.search;


import com.sun.deploy.util.SyncFileAccess;

/**
 * @Author: Administrator
 * @Date: 2020/1/16 :14:06
 * @Description:
 */
public abstract class STSorted<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    /**
     * 最小的键
     *
     * @return
     */
    abstract Key min();

    /**
     * 最大的键
     *
     * @return
     */
    abstract Key max();

    /**
     * 小于等于Key 的最大键
     *
     * @param key
     * @return
     */
    abstract Key floor(Key key);

    /**
     * 大于等于Key的最小键
     *
     * @param key
     * @return
     */
    abstract Key ceiling(Key key);

    /**
     * 小于key的键的数量
     *
     * @param key
     * @return
     */
    abstract int rank(Key key);

    /**
     * 排名为k的键key
     *
     * @param k
     * @return
     */
    abstract Key select(int k);

    /**
     * 删除最小的键
     */
    public void deleteMin() {
        delete(min());
    }

    ;

    /**
     * 删除最大的键
     */
    public void deleteMax() {
        delete(max());
    }

    ;

    /**
     * lo键和hi键之间的数量
     *
     * @param lo
     * @param hi
     * @return
     */
    public int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    ;

    /**
     * lo键和hi键之间的所有键的集合，已排序
     *
     * @param lo
     * @param hi
     * @return
     */
    abstract Iterable<Key> keys(Key lo, Key hi);

    /**
     * 获取所有的键的集合（已排序）
     *
     * @return
     */
    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }
}
