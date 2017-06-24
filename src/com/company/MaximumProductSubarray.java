/*152. Maximum Product Subarray  （面试题31：连续子数组的最大和）
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 
*/
public class MaximumProductSubarray {
    //动态规划
    //time com:O(n), space com:O(1)
    //Runtime: 4 ms, beats 16.35 %
    public int maxProduct(int[] nums) {
        //输入无效，返回0
        if(nums==null || nums.length==0)
            return 0;
        //维护一个局部最大和一个局部最小（考虑到乘法特性）
        int max=nums[0];
        int min=nums[0];
        int global=nums[0];
        for(int i=1; i<nums.length; i++){
            int maxCopy=max; //暂存局部最大变量
            max=Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min=Math.min(nums[i], Math.min(maxCopy*nums[i], min*nums[i]));
            
            global=Math.max(global, max);
        }
        
        return global;
    }
}