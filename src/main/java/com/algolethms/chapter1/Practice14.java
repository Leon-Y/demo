package com.algolethms.chapter1;

/**
 * @Author: Administrator
 * @Date: 2019/10/18 :13:44
 * @Description:
 */
public class Practice14 {
    public static void main(String[] args) {

        System.out.println(lg(9));
    }
    public static int lg(int N){
        if (N == 0){return Integer.MIN_VALUE;}
        int result = 0;
        int top = 0;
        while(true){
            if (result == 0){
                top = 1;
            }else {
                top *= 2;
            }
            if (top > N){
                if (result > 0){
                    result --;
                }
                break;
            }
            result ++;
        }
        return result;
    }
}
