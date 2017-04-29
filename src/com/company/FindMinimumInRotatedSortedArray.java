package com.company;

/**
 * Created by dai on 2017/4/22.
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        // write your code here
        //int[] nums = {};//数组为空
        //int[] nums = {1,2,3};//0个元素搬到最后面
        //int[] nums = {4,5,1,2,3};//真的旋转数组
        int[] nums = {1,1,1,2,1,1};
        System.out.println(findMin(nums));
    }

    //Idea；二分查找（时间复杂度log(n)）
//    因为二分查找每次排除掉一半的不适合值，所以对于n个元素的情况：
//    一次二分剩下：n/2
//    两次二分剩下：n/2/2 = n/4
//            。。。
//    m次二分剩下：n/(2^m)
//    在最坏情况下是在排除到只剩下最后一个值之后得到结果，所以为
//    n/(2^m)=1;
//    2^m=n;
//    所以时间复杂度为：log2(n)

    //数组无重复
//    public static int findMin(int[] nums) {
//        if(nums==null || nums.length==0) return 0;
//        int left=0, right=nums.length-1;
//        if(nums[0] < nums[right]) return nums[0];
//        while(right-left > 1){
//            int mid = (left + right)/2;
//            if(nums[mid] > nums[right])
//                left = mid;
//            else
//                right = mid;
//        }
//        return nums[right];
//    }

    //duplicates are allowed（1）
//    public static int findMin(int[] nums) {
//        if(nums==null || nums.length==0) return 0;
//        int left=0, right=nums.length-1;
//        if(nums[0] < nums[right]) return nums[0];
//        while(right-left > 1){
//            //分析：最小的数可能在两个相等的数中间
//            //顺序查找
//            if(nums[left] == nums[right])
//                return Inmid(nums, left, right);
//            else {
//                int mid = (left + right) / 2;
//                if (nums[mid] > nums[right])
//                    left = mid;
//                else
//                    right = mid;
//            }
//        }
//        return nums[right];
//    }
//    public static int Inmid(int[] nums, int left, int right){
//        for(int i=left+1; i <=right; i++){
//            if(nums[i] < nums[left])
//                return nums[i];
//        }
//        return nums[left];
//    }

    //duplicates are allowed（2）
    public static int findMin(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int left=0, right=nums.length-1;
        //if(nums[0] < nums[right]) return nums[0];
        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] > nums[right])
                left = mid+1;
            else if(nums[mid] < nums[right])
                right = mid;
            else
                right--;//nums[mid] = nums[right],有重复数字。right左移
        }
        return nums[left];
    }
}
