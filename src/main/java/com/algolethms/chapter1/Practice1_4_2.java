package com.algolethms.chapter1;

import java.util.Stack;

/**
 * @Author: Administrator
 * @Date: 2019/12/20 :14:50
 * @Description: 处理int相加溢出的情况
 */
public class Practice1_4_2 {
    public static String myTest(String line) {
        int j = -1;
        Stack<Integer> firstNumStack = new Stack<Integer>();
        Stack<Integer> secondNumStack = new Stack<Integer>();
        Stack<Integer> sum = new Stack<Integer>();
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isDigit(line.charAt(i))) {
                j = j + 1;
                continue;
            } else if (j == -1) {
                firstNumStack.push(Integer.parseUnsignedInt(String.valueOf(line.charAt(i))));
            } else if (j > -1) {
                secondNumStack.push(Integer.parseUnsignedInt(String.valueOf(line.charAt(i))));
            }
        }
        int maxLen = 0;
        if (firstNumStack.size() >= secondNumStack.size()) {
            maxLen = firstNumStack.size();
        }
        else {
            maxLen = secondNumStack.size();
        }

        int carry = 0;
        int firstNum;
        int secondNum;
        int tmpSum;
        while (maxLen != 0) {
            try {
                firstNum = firstNumStack.pop();
            } catch (Exception e1) {
                firstNum = 0;
            }
            try {
                secondNum = secondNumStack.pop();
            } catch (Exception e2) {
                secondNum = 0;
            }
            tmpSum = firstNum + secondNum + carry;
            carry = tmpSum / 10;
            sum.push(tmpSum - carry * 10);
            maxLen -- ;
        }
        if (carry != 0) {
            sum.push(carry);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (sum.size() != 0) {
            stringBuffer.append(String.valueOf(sum.pop()));
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(myTest ("100 456909"));
    }
}
