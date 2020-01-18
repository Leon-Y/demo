package com.algolethms.search;

/**
 * @Author: Administrator
 * @Date: 2020/1/16 :10:46
 * @Description:
 */
public interface ST<Key, Value> {
    /**
     * 插入操作,若value值为空则将Key从表中删除
     *
     * @param key
     */
    void put(Key key, Value value);

    /**
     * 获取key对应的value值，若key不存在则返回null
     *
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * 从表中删除键值及其包含的value
     *
     * @param key
     */
    default void delete(Key key){
        put(key,null);
    };

    /**
     * 表中是否有Key
     *
     * @param key
     * @return
     */
    default boolean contains(Key key){
        return get(key) != null;
    };

    /**
     * 表中的键值对的数量
     *
     * @return
     */
    int size();

    /**
     * 判断是否为空
     *
     * @return
     */
    default boolean isEmpty(){
        return size() == 0;
    };

    /**
     * 表中键的集合
     *
     * @return
     */
    Iterable<Key> keys();
}
