package com.algolethms.chapter1;

import java.math.BigDecimal;

/**
 * @Author: Administrator
 * @Date: 2019/10/21 :15:29
 * @Description:
 */
public class Practice20 {
    public static void main(String[] args) {
        double N = 10;
        System.out.println(Math.log(N));
        System.out.println(ln(N));
        System.out.println(Math.exp(2.30258509));
    }
    private static double ln(double N){
        int count = 0;
        if (N == 1){
            return 0;
        }else if (N <1 && N > 0){
            return lnMid(N,0,1);
        }else if (N>1){
            while (true){
                if (Math.exp(count) > N){
                    return lnMid(N,--count,1);
                }else if (Math.exp(count) == N){
                    return count;
                }
                count++;
            }
        }else {
            return 0;
        }
    }
    public static double lnMid(double N,double x,double point){
        if (point>20){
            return x;
        }
        for (int i = 1;i< 10;i++){
            if (Math.exp(x+(i/(Math.pow(10,point)))) > N){
              x+=((i-1)/(Math.pow(10,point)));
              break;
            }else if (new BigDecimal(String.valueOf(Math.exp(x+(i/(Math.pow(10,point)))))).divide(new BigDecimal(String.valueOf(N))).abs().compareTo(new BigDecimal("0")) == 0){
                return x+((i)/(Math.pow(10,point)));
            }else if (i == 9){
                x+=((i)/(Math.pow(10,point)));
            }
        }
        return lnMid(N,x,++point);
    }
}
