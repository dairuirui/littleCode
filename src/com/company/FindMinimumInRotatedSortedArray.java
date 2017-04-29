package com.company;

/**
 * Created by dai on 2017/4/22.
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        // write your code here
        //int[] nums = {};//����Ϊ��
        //int[] nums = {1,2,3};//0��Ԫ�ذᵽ�����
        //int[] nums = {4,5,1,2,3};//�����ת����
        int[] nums = {1,1,1,2,1,1};
        System.out.println(findMin(nums));
    }

    //Idea�����ֲ��ң�ʱ�临�Ӷ�log(n)��
//    ��Ϊ���ֲ���ÿ���ų���һ��Ĳ��ʺ�ֵ�����Զ���n��Ԫ�ص������
//    һ�ζ���ʣ�£�n/2
//    ���ζ���ʣ�£�n/2/2 = n/4
//            ������
//    m�ζ���ʣ�£�n/(2^m)
//    �������������ų���ֻʣ�����һ��ֵ֮��õ����������Ϊ
//    n/(2^m)=1;
//    2^m=n;
//    ����ʱ�临�Ӷ�Ϊ��log2(n)

    //�������ظ�
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

    //duplicates are allowed��1��
//    public static int findMin(int[] nums) {
//        if(nums==null || nums.length==0) return 0;
//        int left=0, right=nums.length-1;
//        if(nums[0] < nums[right]) return nums[0];
//        while(right-left > 1){
//            //��������С����������������ȵ����м�
//            //˳�����
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

    //duplicates are allowed��2��
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
                right--;//nums[mid] = nums[right],���ظ����֡�right����
        }
        return nums[left];
    }
}
