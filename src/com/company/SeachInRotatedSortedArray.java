package com.company;

/**
 * Created by dai on 2017/4/22.
 */
public class SeachInRotatedSortedArray {
    public static void main(String[] args) {
        // write your code here
        //int[] nums = {};//数组为空
        int[] nums = {4,4,0,1,2,4};//0个元素搬到最后面
        //int[] nums = {4,5,1,2,3};//真的旋转数组
        //int[] nums = {1,0,1,1};
        System.out.println(search(nums,4));
    }
    //1.先找到最小值的index，
    //2.然后确定二分查找的范围
    //时间复杂度log(n)
    //16ms
//    public static int search(int[] nums, int target) {
//        if(nums==null || nums.length==0) return -1;
//        int left=0, right=nums.length-1;
//        //找最小数的index
//        int index;
//        while(left < right){
//            int min = (left + right)/2;
//            if(nums[min] > nums[right])
//                left = min+1;
//            else if(nums[min] < nums[right])
//                right = min;
//            else
//                right--;//nums[min] = nums[right]
//        }
//        index=left;
//        //确认查找范围
//        if(index==0 || (target>=nums[index] && target<=nums[nums.length-1]))
//            return binarySearch(nums, index, nums.length-1, target);
//        else if(target>=nums[0] && target<=nums[index-1])
//            return binarySearch(nums, 0, index-1,target);
//        else
//            return -1;
//    }
//    public static int binarySearch(int[] nums, int left, int right, int target){
//        while(left < right){
//            int mid = (left+right)/2;
//            if(target == nums[mid])
//                return mid;
//            else if(target > nums[mid])
//                left=mid+1;//如果换成left=mid，可能造成死循环，如nums={1，3}，target=2
//            else if(target < nums[mid])
//                right = mid;
//        }
//        if(nums[left] == target)//left==right
//            return left;
//        else
//            return -1;
//    }

    //target分别与nums[left]和nums[right]比较
    //16ms
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int left=0, right=nums.length-1;
        while(left <= right){
            int mid=(left+right)/2;
            if(target == nums[mid])
                return mid;
            if(target >= nums[left]){//>=左边的数
                //与nums[mid]比较
                if(target < nums[mid])
                    right = mid - 1;
                else {
                    if(nums[mid] >= nums[left])//mid在大数一边
                        left = mid + 1;
                    else//mid在小数一边
                        right = mid - 1;
                }

            }else{//<=右边的数
                //与nums[mid]比较
                if(target > nums[mid])
                    left = mid + 1;
                else{
                    if(nums[mid] <= nums[right])//mid在小数一边
                        right = mid - 1;
                    else//mid在大数一边
                        left = mid + 1;
                }
            }
        }
        return -1;
    }
}
