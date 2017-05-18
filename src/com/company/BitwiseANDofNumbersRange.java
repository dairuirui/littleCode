package com.company;

/**
 * Created by dai on 2017/5/8.
 */
public class BitwiseANDofNumbersRange {

    public static void main(String args[]){
        System.out.println(rangeBitwiseAnd2(5, 7));
    }

    //循环与，这种方法超时。
//    public static int rangeBitwiseAnd(int m, int n) {
//        if(m == 0)
//            return 0;
//        if(m==n)
//            return m;
//        int result = m & (m+1);
//        for(int i=m+2; i<=n; i++){
//            result = result & i;
//            if(result == 0)
//                return 0;
//        }
//        return result;
//    }


    //注：其实方法1和方法2的基本思想是一样的

    /*
    The idea is very simple:

    last bit of (odd number & even number) is 0.
    when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
    Move m and n rigth a position.

    Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.
    */
    //Runtime: 8 ms,  beats 70.99 %
    public static int rangeBitwiseAnd1(int m, int n){
        if(m == 0)
            return 0;
        int moveFactor = 1;
        while(m != n){
            m <<= 1;
            n <<= 1;
            moveFactor >>=1;
        }
        return m*moveFactor;
    }

    /*
    The idea is to use a mask to find the leftmost common digits of m and n.
    Example: m=1110001, n=1110111, and you just need to find 1110000 and it will be the answer.
    */
    //Runtime: 8 ms,, beats 70.99 %
    public static int rangeBitwiseAnd2(int m, int n){
        int r=Integer.MAX_VALUE;
        while((m&r) != (n&r))
            r <<= 1;
        return m&r;
    }
}
