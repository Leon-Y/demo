package com.algolethms.chapter1;

import com.algolethms.Utils.Queue;
import com.algolethms.Utils.Stack;

/**
 * @Author: Administrator
 * @Date: 2019/11/8 :13:47
 * @Description: 补充括号
 */
public class Practice1_3_9 {
    public static void main(String[] args) {
//        System.out.println((Integer.valueOf('(') == '('));
        System.out.println(Integer.valueOf('1'));
        System.out.println(repair("1+2)*3-4)*5-6)))"));
    }

    public static String repair(String equation) {
        Stack<Character> number = new Stack<>();
        Stack<Character> symbol = new Stack<>();
        Stack<String> result = new Stack<>();
        Character cup;
        char[] chars = equation.trim().toCharArray();
        for (Character character : chars) {
            if (character >= 48 && character < 58) {
                number.push(character);
            } else if (character == 40) {
                continue;
            } else if (character == 41) {
                String last = String.valueOf(((cup = number.pop()) == null ? result.pop() : cup));
                String first = String.valueOf(((cup = number.pop()) == null ? result.pop() : cup));
                String cell = "(" + first + symbol.pop() + last + ")";
                result.push(cell);
            } else if (character == 42 || character == 43 || character == 45 || character == 47){
                symbol.push(character);
            }else {
                continue;
            }
        }
        return result.toString();
    }
}
