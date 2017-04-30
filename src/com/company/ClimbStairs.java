package com.company;

/**
 * Created by dai on 2017/4/30.
 */
public class ClimbStairs {
    public static void main(String args[]){
        System.out.print(climbStairs(44));
    }

    /*
    * 设f(n)表示爬到第n 阶楼梯的方法数，为了爬到第n阶楼梯，有以下两种选择：
      ? 从第f(n-1)阶前进1步；
      ? 从第f(n-2)阶前进2步；
      则f(n)可写成：f(n) = f(n-1) + f(n-2)
    * */

    //递归（动态规划算法DP）：存在很多重复的运算
    //超时
//    public static int climbStairs(int n){
//        if(n<0) return 0;
//        return Fibonacci(n);
//    }
//    public static int Fibonacci(int n){
//        //与斐波那契的初始值不一样
//        if(n==1) return 1;
//        else if(n==2) return 2;
//        else return Fibonacci(n-1)+Fibonacci(n-2);
//    }

    //分治法：可以把楼梯砍一半，爬一半的方法数*另一半的方法数是不是就等于最终答案呢，不止，还少算了如果在这两半楼梯的联接处正好走两步时的情况
    //runtime:0ms,beats 17.41 %
//    public static int climbStairs(int n){
//        if(n<=3) return n;
//        //n为偶数
//        int leftCount=climbStairs(n/2);
//        int rightCount=leftCount;
//        int leftCount2=climbStairs(n/2-1);
//        int rightCount2=leftCount2;
//        if(n%2 == 1){//n为奇数
//            rightCount=leftCount+leftCount2;//climbStairs(n/2+1)
//            rightCount2=leftCount;
//        }
//        return leftCount*rightCount + leftCount2*rightCount2;
//    }

    //循环：从下往上计算，首先F(0)和f(1)计算f(2),然后游f(1)和f(2)计算f(3)......
    //time com:O(n), space com:O(1)
    //runtime:0ms,beats 17.41 %
    public static int climbStairs(int n){
        if(n<=2) return n;
        int fib1=1, fib2=2, fibN=0;
        for(int i=3; i<=n; i++){
            fibN=fib1+fib2;
            fib1=fib2;
            fib2=fibN;
        }
        return fibN;
    }

}
