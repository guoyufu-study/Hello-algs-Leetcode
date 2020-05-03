package com.jasper.algs.leetcode.heap.qu0215.solu1;

import java.util.PriorityQueue;

/**
 * 0215. 数组中的第K个最大元素
 * 
 * <p> 最小堆
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {

    	// 最小堆
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	for (int num : nums) {
			if(queue.size() < k) {
				queue.offer(num);
			} else if(num > queue.peek()){
				queue.poll();
				queue.offer(num);
			}
		}
    	
    	return queue.peek();
    }
}