package com.jasper.algs.leetcode.greedy.qu0045.solu2;

/**
 * 0045.跳跃游戏 II
 *
 * <p>贪心算法
 */
class Solution {
    public int jump(int[] nums) {
    	
    	// 边界：起点即终点
    	if(nums.length==1) return 0;
    	
    	int target = nums.length-1;
    	int rightmost = nums[0];// 能够到达的最远位置
    	int index = 0; // 当前处理的位置
    	
    	// 遍历能够到达的所有位置
    	int ans = 0;
    	while(index<=rightmost) {
    		// 走一步
    		ans++;
    		
    		// 能到终点
    		if(rightmost>=target) break;
    		
    		// 未到终点：更新下一步能到达的最远位置
    		int most = rightmost;
    		index++;
    		for (; index <= most; index++) {
    			rightmost = Math.max(rightmost, index+nums[index]);
			}
    		index = most;
    	}
    	
    	return ans;
    }
}