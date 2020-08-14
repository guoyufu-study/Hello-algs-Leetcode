package com.jasper.algs.interview.qu1709.solu1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1577. 面试题 17.09. 第 k 个数
 * 
 * <p> 优先队列
 */
class Solution {
    public int getKthMagicNumber(int k) {

    	PriorityQueue<Long> queue = new PriorityQueue<>();
    	queue.offer(1L);
    	
    	Set<Long> set = new HashSet<>();
    	set.add(1L);
    	while(k>1) {
    		long poll = queue.poll();
    		
    		long num = poll * 3;
    		if(!set.contains(num)) {
    			queue.offer(num);
    			set.add(num);
    		}
    		
    		num = poll * 5;
    		if(!set.contains(num)) {
    			queue.offer(num);
    			set.add(num);
    		}
    		
    		num = poll * 7;
    		if(!set.contains(num)) {
    			queue.offer(num);
    			set.add(num);
    		}
    		
    		System.out.println(k +":"+poll);
    		k--;
    	}
    	
    	return queue.poll().intValue();
    }
    
    public static void main(String[] args) {
    	// 9
//    	int k = 5;
		
    	// 45
//    	int k = 11;
    	
    	// 1937102445
    	int k = 643;
    	System.out.println(new Solution().getKthMagicNumber(k));
	}
}