package com.jasper.algs.sword2offer.qu021.solu1;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 
 * <p> 双指针
 */
class Solution {
    public int[] exchange(int[] nums) {
    	int left = 0, right = nums.length-1;
    	while(left < right) {
    		while(left < right && nums[left]%2==1) left++; // 找到偶数
    		while(left < right && nums[right]%2==0) right--; // 找到奇数
    		
    		if(left >= right) break;
    		nums[left] = nums[left] ^ nums[right];
    		nums[right] = nums[left] ^ nums[right];
    		nums[left] = nums[left] ^ nums[right];
    	}
    	return nums;
    }
}