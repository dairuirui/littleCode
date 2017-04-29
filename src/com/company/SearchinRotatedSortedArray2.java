package com.company;

/**
 * Created by dai on 2017/4/25.
 */
public class SearchinRotatedSortedArray2 {
    public static void main(String[] args) {
        // write your code here
        //int[] nums = {};//数组为空
        int[] nums = {1,1,3,1};//0个元素搬到最后面
        //int[] nums = {4,5,1,2,3};//真的旋转数组
        //int[] nums = {1,0,1,1};
        System.out.println(search(nums, 3));
    }

    public static boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return false;
        int left=0, right=nums.length-1, mid=-1;
        while(left <= right){
            mid = (left + right) /2;
            if(target == nums[mid])
                return true;
            if(nums[mid] < nums[left] || nums[mid] < nums[right]){//mid在右边,注：后一种情况是非旋转数组
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else if(nums[mid] > nums[right] || nums[mid] > nums[left]){//mid在左边，注：后一种情况是非旋转数组
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{//nums[mid]==nums[left]==nums[right]
                right--;//去重，也可以left--;
            }
        }
        return false;
    }
}
