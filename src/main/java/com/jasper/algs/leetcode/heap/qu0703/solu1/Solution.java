package com.jasper.algs.leetcode.heap.qu0703.solu1;

import java.util.PriorityQueue;

/**
 * 0703. 数据流中的第K大元素
 * 
 * <p> 使用 PriorityQueue API
 */
class KthLargest {

	// 最小堆
	private final PriorityQueue<Integer> queue;
	private final int K;
    public KthLargest(int k, int[] nums) {
    	K = k;
    	// 填充堆
    	queue = new PriorityQueue<Integer>();
    	for (int i : nums) {
			queue.add(i);
			if(queue.size() > k) queue.poll();
		}
    }
    
    public int add(int val) {
    	queue.add(val);
    	if(queue.size() > K) queue.poll();
    	return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */