package com.jasper.algs.leetcode.backtracking.qu1298.solu1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1298. 你能从盒子里获得的最大糖果数
 *
 * <p> BFS
 */
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    	// 边界
    	if(initialBoxes.length==0) 
    		return 0;
    	
    	// 手中已开锁的箱子
    	Queue<Integer> opened = new LinkedList<Integer>();
    	// 手中未开锁的箱子
    	Set<Integer> closed = new HashSet<Integer>();
    	
    	// 初始化
    	for (int i : initialBoxes) {
			if(status[i]==1)
				opened.add(i);
			else 
				closed.add(i);
		}
    	
    	int ans = 0;
    	while(!opened.isEmpty()) {
    		// 统计糖果
    		int i = opened.poll();
    		ans += candies[i];
    		
    		// 开锁
    		for (int key : keys[i]) {
    			status[key] = 1;
    			if(closed.contains(key)) {
    				opened.add(key);
    				closed.remove(key);
    			}
			}
    		
    		// 获取箱子
    		for (int containedBox : containedBoxes[i]) {
    			if(status[containedBox]==1)
    				opened.add(containedBox);
    			else 
    				closed.add(containedBox);
			}
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	
    	int[] status = new int[] {1,0,1,0};
    	int[] candies = new int[] {7,5,4,100};
    	int[][] keys = new int[][] {{},{},{1},{}};
    	int[][] containedBoxes = new int[][] {{1,2},{3},{},{}};
    	int[] initialBoxes = new int[] {0};
    	
    	System.out.println(new Solution().maxCandies(status, candies, keys, containedBoxes, initialBoxes));
	}
}
