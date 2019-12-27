package com.algolethms.Utils;

/**
 * @Author: Administrator
 * @Date: 2019/11/4 :16:49
 * @Description: 栈的实现
 */
public class Stack<T> {
    //当前的节点
    private Node position;
    //计数
    private int count;

    private class Node{
        T item;
        Node node;
    }
    //pop 移除栈顶的数据
    public T pop(){
        if (position == null){
            return null;
        }else {
            T item = position.item;
            position = position.node;
            count--;
            return item;
        }
    }
    //push 向栈顶添加数据
    public void push(T item){
        Node newNode = new Node();
        newNode.node = position;
        newNode.item = item;
        position = newNode;
        count++;
    }
    //返回最近添加的元素
    public T peek(){
        if (position == null){
            return null;
        }
        return position.item;
    }
    public boolean isEmpty(){
        return position == null;
    }
    public int size(){
        return count;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node item = position;
        while (item != null){
            stringBuilder.append(String.valueOf(item.item));
            item = item.node;
        }
        return stringBuilder.toString();
    }
}
