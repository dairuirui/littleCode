package com.company;

/**
 * Created by dai on 2017/4/22.
 */
public class RotateArray {
    //利用新数组
    //time com: O(n)，space com: O(n)
    //run time:1ms
//    public void rotate(int[] nums, int k) {
//        int[] temp = new int[nums.length];
//        for(int i=0; i<nums.length; i++){
//            temp[(i+k)%nums.length] = nums[i];//K个数插入前面
//        }
//        for(int j=0; j<nums.length; j++){
//            nums[j] = temp[j];
//        }
//    }


    //反转
    // Let n=7n=7n=7 and k=3k=3k=3.
    /*
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
    */
    //Time complexity : O(n)，Space complexity : O(1)
    //runtime:1ms
    public void rotate(int[] nums, int k){
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length);
    }
    public void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //
}
