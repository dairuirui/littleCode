/*53. Maximum Subarray （面试题31：连续子数组的最大和）
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
*/
public class MaximumSubarray {

    //举例分析数组的规律 or 动态规划  （代码一致）
    //time com:O(n), space com:O(1)
    //Runtime: 17 ms, beats 37.38 %
    public int maxSubArray1(int[] nums) {
        //数组输入无效，返回-1
        if(nums==null || nums.length==0)
            return -1;
        
        int curSum=nums[0];
        int greatSum=nums[0];
        for(int i=1; i<nums.length; i++){
            if(curSum<=0) curSum=nums[i]; //当前和为负，丢弃之前的累加
            else curSum+=nums[i]; //累加当前和
            
            if(curSum>greatSum) greatSum=curSum; //更新最大和
        }
        
        return greatSum;
    }


}