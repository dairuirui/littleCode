package com.company;

/**
 * Created by dai on 2017/5/9.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    //Runtime: 2 ms���� beats 47.71 %
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++){
            //ע�⣺����λ���ټ�
            result <<= 1;
            result += (n&1);
            n >>= 1;
        }
        return result;
    }
}
