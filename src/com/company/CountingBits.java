package com.company;

/**
 * Created by dai on 2017/5/8.
 */
public class CountingBits {
    // idea: f[i] = f[i / 2] + i % 2.
    //Runtime: 3 ms,, beats 39.08 %
    public int[] countBits(int num) {
        int[] count = new int[num+1];
        for(int i=1; i<=num; i++)
            count[i] = count[i>>1]+i%2;
        return count;
    }
}
