package com.jasper.algs.leetcode.heap.qu0347.solu1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 0347.前 K 个高频元素
 * 
 * <p> HashMap 统计频次
 * <p> 最小堆计算TopK问题
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    	// 统计频次
    	Map<Integer,Integer> map = new HashMap<>();
    	for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
    	
    	// 最小堆
    	PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
    		return o1[1] - o2[1];
    	});
    	for (Integer key : map.keySet()) {
			if(queue.size() < k)
				queue.offer(new int[] {key, map.get(key)});
			else if(map.get(key) > queue.peek()[1]) {
				queue.poll();
				queue.offer(new int[] {key, map.get(key)});
			}
		}
    	
    	// 构造答案
    	int[] ans = new int[k];
    	for (int i = k-1; i >= 0; i--) {
			ans[i] = queue.poll()[0];
		}
    	
    	return ans;
    }
}