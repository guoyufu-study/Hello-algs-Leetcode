package com.jasper.algs.contest.weekly.c187.qu1438.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 * 
 * <p> 滑动窗口+单调队列
 */
class Solution {
    public int longestSubarray(int[] nums, int limit) {

    	int left=0, right=0;//滑动窗口
    	Deque<Integer> minQ = new LinkedList<Integer>();// 单调非递减队列（相等或递增）
    	Deque<Integer> maxQ = new LinkedList<Integer>();// 单调非递增队列（相等或递减）
    	
    	int ans = 0;
    	for (; right < nums.length;) {
			// 维护单调非递减队列
    		while(!minQ.isEmpty() && nums[minQ.peekLast()]>nums[right])
    			minQ.pollLast();
    		minQ.add(right);
    		
    		// 维护单调非递增队列
    		while(!maxQ.isEmpty() && nums[maxQ.peekLast()]<nums[right])
    			maxQ.pollLast();
    		maxQ.add(right);
    		
    		// 收缩窗口
    		while(!minQ.isEmpty() && !maxQ.isEmpty() &&
    				nums[maxQ.peek()] - nums[minQ.peek()] > limit) {
//    			if(minQ.peek()<=left) minQ.poll();
//    			if(maxQ.peek()<=left) maxQ.poll();
    			left = maxQ.peek()<minQ.peek() ? maxQ.poll() : minQ.poll();// 优化
    			left++;
    		}
    		
    		// 扩展窗口
    		right++;
    		
    		ans = Math.max(ans, right-left);
		}
    	
    	return ans;
    	
    }
    
    
    public static void main(String[] args) {
    	// 3
//		int[] nums = new int[] {4,2,2,2,4,4,2,2};
//		int limit = 0;
		
		
		// 4
//		int[] nums = new int[] {10,1,2,4,7,2};
//		int limit = 5;
		
		// 2
//		int[] nums = new int[] {8,2,4,7};
//		int limit = 4;
    	
    	// 3
//		int[] nums = new int[] {8,2,4,7,3};
//		int limit = 4;
    	
		// 4
		int[] nums = new int[] {3,2,1,4,2,2,2,5};
		int limit = 2;
		
		System.out.println(new Solution().longestSubarray(nums, limit));
		
	}
}