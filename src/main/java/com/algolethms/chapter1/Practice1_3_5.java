package com.algolethms.chapter1;

import com.algolethms.Utils.Stack;

/**
 * @Author: Administrator
 * @Date: 2019/11/8 :9:54
 * @Description: 十进制转换二进制
 */
public class Practice1_3_5 {
    public static void main(String[] args) {
        System.out.println(decimalTobinary(256));
    }
    public static String decimalTobinary(int decimal){
        Stack<Integer> integerStack = new Stack<>();
        while (decimal > 0){
            integerStack.push(decimal%2);
            decimal = decimal/2;
        }
        return integerStack.toString();
    }
}
