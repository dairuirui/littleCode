package com.company;

import java.util.Map;

/**
 * Created by dai on 2017/5/9.
 */
public class Pow {
    public static void main(String args[]){
        System.out.println(myPow2(2, Integer.MIN_VALUE));
    }

    //预先判断所有情况
    //Runtime: 28 ms，beats 13.32 %
    public static double myPow1(double x, int n) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 ==0) return 1;
            else return -1;
        }
        if(n == Integer.MIN_VALUE) return 0;
        if(n < 0) return 1/myPow1(x, Math.abs(n));
        if(n == 0) return 1;
        double result = x;
        for(int i=1; i<n; i++){
            result *= x;
            //x为0.000001，避免超时
            if(result == 0)
                return 0;
        }
        return result;
    }

    //采用全局变量来标志是否出错，如果错了，修改全局变量，并返回0.(其实和上一种方法的idea是一样的，试试加了检错的全局变量)
    //Runtime: 41 ms, beats 1.21 %
    static boolean invalidInput = false;
    public static double myPow2(double x, int n) {
        //x为1或-1情况，避免超时（注意放在n == Integer.MIN_VALUE前面，因为1的任何次幂为1）
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 ==0) return 1;
            else return -1;
        }
        //输入不合法，设置全局变量，并返回0
        if((x == 0 && n <= 0) || n == Integer.MIN_VALUE){
            invalidInput = true;
            return 0;
        }
        if(x == 0) return 0;
        if(n == 0) return 1;
        double result = x;
        for(int i=1; i<Math.abs(n); i++){//指数n有可能为负数
            result *= x;
            //x为0.000001，避免超时
            if(result == 0)
                return 0;
        }
        if(n < 0)
            result = 1/result;
        return result;
    }

    //使用递归，先求平方，在平方的基础上求4次方，然后求8次方。。。。。。
    //Runtime: 20 ms，beats 79.36 %
    public double myPow(double x, int n) {
        //x为1或-1情况，避免超时（注意放在n == Integer.MIN_VALUE前面，因为1的任何次幂为1）
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 ==0) return 1;
            else return -1;
        }
        //输入不合法，设置全局变量，并返回0
        if((x == 0 && n <= 0) || n == Integer.MIN_VALUE){
            invalidInput = true;
            return 0;
        }
        if(x == 0) return 0;
        if(n == 0) return 1;
        int unsignedN = Math.abs(n);
        double result = powWithUnsignedN(x,unsignedN);
        if(n < 0)
            result = 1/result;
        return result;
    }
    public static double powWithUnsignedN(double x, int n){
        if(n == 1) return x;
        if(n == 0) return 1;
        double result = powWithUnsignedN(x,n>>1);//用右移代替除2.效率更高
        result *= result;
        if((n&1) == 1)//用与运算代替求余运算符%，提高效率
            result *= x;
        return result;
    }

}
