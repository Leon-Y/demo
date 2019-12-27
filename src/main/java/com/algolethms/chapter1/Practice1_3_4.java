package com.algolethms.chapter1;

import com.algolethms.Utils.Stack;

import java.util.Scanner;

/**
 * @Author: Administrator
 * @Date: 2019/11/5 :9:25
 * @Description:
 */
public class Practice1_3_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Practice1_3_4 practice1_3_4 = new Practice1_3_4();
        boolean b = practice1_3_4.judgeMent(s);
        System.out.println(b);
    }

    public boolean judgeMent(String args) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < args.length(); i++) {
            if (!String.valueOf(args.charAt(i)).equals(")") && !String.valueOf(args.charAt(i)).equals("]")&& !String.valueOf(args.charAt(i)).equals("}")) {
                characterStack.push(args.charAt(i));
            } else if (String.valueOf(args.charAt(i)).equals(")")) {
                Character pop = characterStack.pop();
                while (pop != null && !String.valueOf(pop).equals("(")) {
                    pop = characterStack.pop();
                }
                if (pop == null) {
                    return false;
                }
            } else if (String.valueOf(args.charAt(i)).equals("]")) {
                Character pop = characterStack.pop();
                while (pop != null && !String.valueOf(pop).equals("[")) {
                    pop = characterStack.pop();
                }
                if (pop == null) {
                    return false;
                }
            } else if (String.valueOf(args.charAt(i)).equals("}")) {
                Character pop = characterStack.pop();
                while (pop != null && !String.valueOf(pop).equals("{")) {
                    pop = characterStack.pop();
                }
                if (pop == null) {
                    return false;
                }
            }
        }
        while (characterStack.pop() != null){
            if (String.valueOf(characterStack.pop()).equals("{") || String.valueOf(characterStack.pop()).equals("[") ||String.valueOf(characterStack.pop()).equals("(")){
                return false;
            }
        }
        return true;
    }
}
