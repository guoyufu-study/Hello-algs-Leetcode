package com.jasper.algs.sword2offer.qu057.solu1;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 
 * <p> 双指针
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int left = 0, right = nums.length - 1;
    	while(left < right) {
    		int sum = nums[left] + nums[right];
    		if(sum < target) left++;
    		else if(sum > target) right--;
    		else 
    			return new int[] {nums[left], nums[right]};
    	}
    	
    	return new int[0];
    }
}