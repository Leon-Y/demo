package com.algolethms.Utils;

/**
 * @Author: Administrator
 * @Date: 2019/11/8 :10:21
 * @Description:
 */
public class Queue<T> {

    private Node firstNode;

    private Node lastNode;

    private int count;

    private class Node{
        T item;
        Node node;
    }

    //从表头拿取元素
    public T take(){
        if (firstNode == null){
            return null;
        }
        T item = firstNode.item;
        firstNode = firstNode.node;
        count--;
        return item;
    }
    //向表尾添加元素
    public void push(T item){

        Node newLastNode = new Node();
        newLastNode.item = item;
        if (firstNode == null){
            firstNode =newLastNode;
            lastNode = newLastNode;
        }else{
            lastNode.node = newLastNode;
            lastNode = newLastNode;
        }
        count++;
    }
    //获取当前的队首元素
    public T peek(){
        return firstNode.item;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node item = firstNode;
        while (item != null){
            stringBuilder.append(String.valueOf(item.item));
            item = item.node;
        }
        return stringBuilder.toString();
    }
}
