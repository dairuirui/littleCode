package com.company;

/**
 * Created by dai on 2017/4/22.
 */
public class SeachInRotatedSortedArray {
    public static void main(String[] args) {
        // write your code here
        //int[] nums = {};//����Ϊ��
        int[] nums = {4,4,0,1,2,4};//0��Ԫ�ذᵽ�����
        //int[] nums = {4,5,1,2,3};//�����ת����
        //int[] nums = {1,0,1,1};
        System.out.println(search(nums,4));
    }
    //1.���ҵ���Сֵ��index��
    //2.Ȼ��ȷ�����ֲ��ҵķ�Χ
    //ʱ�临�Ӷ�log(n)
    //16ms
//    public static int search(int[] nums, int target) {
//        if(nums==null || nums.length==0) return -1;
//        int left=0, right=nums.length-1;
//        //����С����index
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
//        //ȷ�ϲ��ҷ�Χ
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
//                left=mid+1;//�������left=mid�����������ѭ������nums={1��3}��target=2
//            else if(target < nums[mid])
//                right = mid;
//        }
//        if(nums[left] == target)//left==right
//            return left;
//        else
//            return -1;
//    }

    //target�ֱ���nums[left]��nums[right]�Ƚ�
    //16ms
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int left=0, right=nums.length-1;
        while(left <= right){
            int mid=(left+right)/2;
            if(target == nums[mid])
                return mid;
            if(target >= nums[left]){//>=��ߵ���
                //��nums[mid]�Ƚ�
                if(target < nums[mid])
                    right = mid - 1;
                else {
                    if(nums[mid] >= nums[left])//mid�ڴ���һ��
                        left = mid + 1;
                    else//mid��С��һ��
                        right = mid - 1;
                }

            }else{//<=�ұߵ���
                //��nums[mid]�Ƚ�
                if(target > nums[mid])
                    left = mid + 1;
                else{
                    if(nums[mid] <= nums[right])//mid��С��һ��
                        right = mid - 1;
                    else//mid�ڴ���һ��
                        left = mid + 1;
                }
            }
        }
        return -1;
    }
}
