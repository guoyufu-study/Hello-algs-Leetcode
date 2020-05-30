package com.jasper.algs.sword2offer.qu1648.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题59 - I. 滑动窗口的最大值
 *
 * <p>单调不递增双端队列
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	// 边界
    	if(nums==null || nums.length==0)
    		return new int[0];
    	
    	int N = nums.length;
    	int[] ans = new int[N-k+1];
    	Deque<Integer> maxs = new LinkedList<>(); // 单调不递增双端队列
    	
    	// 滑动窗口
    	int left=0, right=0; // 左右指针
    	while (right < N) {
    		// 维护右指针
			while(!maxs.isEmpty() && maxs.peekLast()<nums[right]) {
				// 维护单调不递增双端队列
				maxs.pollLast();
			}
			maxs.offer(nums[right]);
    					
    		// 左指针前进
			int i = right-k+1; // 答案索引
			if(i==left) {
				// 计算结果
				ans[i] = nums[left]==maxs.peekFirst() ? maxs.pollFirst() : maxs.peek();
				left++;
			}
			
			// 右指针前进
			right++;
		}
    	
    	return ans;
    }
}