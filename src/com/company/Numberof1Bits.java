package com.company;

/**
 * Created by dai on 2017/4/30.
 */
public class Numberof1Bits {
    public static void main(String args[]){
        System.out.println(hammingWeight1(9));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {//码重
        //除法的效率比移位运算低很多，实际编程中应尽可能使用移位运算符代替乘除法
        //利用与运算判断各个位是不是1，需要循环32次
        int count = 0;
        int flag = 1;
        while(flag!=0){

            if((n & flag) !=0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {//码重
        //把一个整数减去1，在和原整数做与运算，会把该整数最右边的1变成0. 那么一个整数的二进制中有多少个1，就可以进行几次这样的操作。
        //整数中有几个1就只需要循环几次
        //Runtime: 1 ms， beats 90.35 %
        int count = 0;
        while(n!=0){
            n = (n-1) & n;
            count++;
        }
        return count;
    }
}
