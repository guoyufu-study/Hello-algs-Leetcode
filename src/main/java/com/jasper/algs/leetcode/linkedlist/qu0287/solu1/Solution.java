package com.jasper.algs.leetcode.linkedlist.qu0287.solu1;


/**
 * 二分查找
 */
class Solution {
    public int findDuplicate(int[] nums) {
    	int n = nums.length-1;// n个抽屉，n+1个苹果
    	
    	return find(nums, 1, n);
    }
    
    
    private int find(int[] nums, int left, int right) {
    	
    	if(left==right) 
    		return left;
    	int count = 0;
    	int mid = (left+right)/2;
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]>= left && nums[i]<=mid)
        		count++;
		}
    	
    	if(count>mid-left+1) // 闭区间
    		return find(nums, left, mid);
    	
    	return find(nums, mid+1, right);
    }
    
    
    public static void main(String[] args) {
    	int[] nums = new int[] {1,3,4,2,2};
//    	int[] nums = new int[] {1,1};
    	
    	System.out.println(new Solution().findDuplicate(nums));
	}
}