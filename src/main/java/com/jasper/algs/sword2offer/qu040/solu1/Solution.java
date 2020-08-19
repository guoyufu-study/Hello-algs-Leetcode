package com.jasper.algs.sword2offer.qu040.solu1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题40. 最小的k个数
 * 
 * <p>1.使用现成API
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
    	
    	// 边界
    	if(arr.length==0 || k == 0) return new int[0];
    	if(arr.length == k) return arr;
    	
    	// 最大堆
    	PriorityQueue<Integer> queue = 
    			new PriorityQueue<Integer>(Comparator.reverseOrder());
    	for (int item : arr) {
			queue.add(item);
			if(queue.size() > k) queue.poll();
		}
    	
    	// 构造答案
    	int[] ans = new int[k];
    	for (int i = 0; i < k; i++) {
			ans[i] = queue.poll();
		}
    	
    	return ans;
    }
}