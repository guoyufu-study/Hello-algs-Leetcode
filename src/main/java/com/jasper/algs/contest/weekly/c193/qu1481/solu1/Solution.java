package com.jasper.algs.contest.weekly.c193.qu1481.solu1;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1481. 不同整数的最少数目
 * 
 * <p> 辅助字典 + 排序 + 贪心算法
 */
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
    	
    	// 辅助字典
    	Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    	for (int num : arr) {
			counts.put(num, counts.getOrDefault(num, 0)+1);
		}
    	// 频次排序
    	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    	for (int num : counts.values()) {
			queue.add(num);
		}
    	
    	// 贪心算法
    	while(!queue.isEmpty()) {
    		k -= queue.poll();
    		if(k<0) 
    			return queue.size() + 1;
    		if(k==0)
    			return queue.size();
    	}
    	
    	return 0;
    }
}