package com.jasper.algs.leetcode.twopointers.qu0239.solu2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 0239. 滑动窗口最大值
 *
 * <p> 双向队列（单调非递增）
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	
    	int n = nums.length;
    	int[] ans = new int[n-k+1];
    	Deque<Integer> maxs = new ArrayDeque<>(); // 双向队列（单调非递增）:存储可能的最大值
    	
    	// 滑动窗口
    	int left=0, right=0; // 左右指针
    	while (right < n) {
    		// 维护右指针
			while(!maxs.isEmpty() && nums[maxs.peekLast()]<nums[right]) {
				// 维护单调不递增双端队列
				maxs.pollLast();
			}
			maxs.offer(right);
    					
    		// 维护左指针
			int i = right-k+1; // 答案索引
			if(i==left) {
				// 计算结果
				ans[i] = left==maxs.peekFirst() ? nums[maxs.pollFirst()] : nums[maxs.peek()];
				left++;
			}
			
			// 右指针前进
			right++;
		}
    	
    	return ans;
    }
}