package com.jasper.algs.leetcode.greedy.qu1046.solu1;

import java.util.PriorityQueue;

/**
 * 1046.最后一块石头的重量
 * 
 * <p> 优先级队列
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
    	
        // 构造最大堆
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
    		return b - a;
    	}) ;
    	
    	for (int i = 0; i < stones.length; i++) {
			queue.add(stones[i]);
		}
    	
    	// 模拟石头相撞
    	while(queue.size()>1) {
    		int bigger = queue.poll();
    		int smaller = queue.poll();
    		int newer = bigger-smaller;
			if(newer>0)
				queue.add(newer);
    	}
    	
    	return queue.isEmpty() ? 0 : queue.poll();
    }
}