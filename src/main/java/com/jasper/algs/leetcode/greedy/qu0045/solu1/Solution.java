package com.jasper.algs.leetcode.greedy.qu0045.solu1;

/**
 * 0045.跳跃游戏 II
 *
 * <p> 滑动窗口
 */
class Solution {
    public int jump(int[] nums) {
    	
    	// 边界：起点即终点
    	int length = nums.length;
		if(length==1) return 0;
    	
    	int left=0, right = Math.min(nums[0], length-1);
    	int most = right;
    	int ans = 0;
    	while(left<length) {
    		// 越界 
    		if(left>right) return -1;
    		
    		most = Math.max(most, Math.min(nums[left]+left, length-1));
    		
    		// 扩展窗口
    		if(left==right) {
    			right = most;
    			ans++;
    		}
    		
    		// 收缩窗口
    		left++;
    	}
    	
    	return ans;
    }
    public static void main(String[] args) {
    	// 2
//		int[] nums = new int[] {2,3,1,1,4};
		
		// 1
		int[] nums = new int[] {2,4};
		
		System.out.println(new Solution().jump(nums));
	}
}