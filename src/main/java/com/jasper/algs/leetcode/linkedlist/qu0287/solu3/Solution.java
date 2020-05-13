package com.jasper.algs.leetcode.linkedlist.qu0287.solu3;

/**
 * 快慢指针
 */
class Solution {
    public int findDuplicate(int[] nums) {
    	
    	int slow=0, fast=0; //快慢指针所指定索引
    	// 判断有环
    	do {
    		slow = nums[slow];
    		fast = nums[nums[fast]];
    	} while(slow!=fast);
    	
    	// 环入口
    	fast = 0;
    	do {
    		slow = nums[slow];
    		fast = nums[fast];
    	} while(slow!=fast);
    	
		return fast;
    }
    
    
    
    
    public static void main(String[] args) {
    	int[] nums = new int[] {1,3,4,2,2};
//    	int[] nums = new int[] {1,1};
    	
    	System.out.println(new Solution().findDuplicate(nums));
    	
	}
}