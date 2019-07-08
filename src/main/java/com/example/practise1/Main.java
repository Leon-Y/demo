package com.example.practise1;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num =  scanner.nextInt();
        int n = 1;
        while(true){
            if((2*n*n-1)>num){
                break;
            }
            n++;
        }
        for(int i = 0 ;i < (n-1);i++) {
            for (int j = 0; j < (2*i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}