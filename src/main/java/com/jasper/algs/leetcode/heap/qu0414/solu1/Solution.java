package com.jasper.algs.leetcode.heap.qu0414.solu1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 0414. 第三大的数
 * 
 * <p>最小堆 + 字典
 */
class Solution {
    public int thirdMax(int[] nums) {
    	// 最小堆
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	int k = 3;
    	// 字典去重
    	Set<Integer> set = new HashSet<Integer>();
    	for (int num : nums) {
    		// 重复跳过
    		if(set.contains(num)) continue;
    		
    		// 填充堆
			if(queue.size() < k) { // 入堆
				queue.offer(num);
				set.add(num);
			} else if(num > queue.peek()) { // 更新堆
				queue.poll();
				queue.offer(num);
				set.add(num);
			}
		}
    	
    	if(queue.size() == k) return queue.poll();
    	if(queue.size()==2) queue.poll();
    	
    	return queue.poll();
    }
}