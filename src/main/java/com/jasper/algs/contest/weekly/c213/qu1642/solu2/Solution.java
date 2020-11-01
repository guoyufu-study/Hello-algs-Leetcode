package com.jasper.algs.contest.weekly.c213.qu1642.solu2;

import java.util.PriorityQueue;

/**
 * 1642. 可以到达的最远建筑
 * 
 * <p> 贪心算法：先梯后砖
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        for(int i=1; i<n; i++) {
        	int h = heights[i] - heights[i-1];
        	if(h>0) {
        		minQ.offer(h);// 先用梯
        		if(minQ.size()>ladders) {// 梯不足
        			bricks -= minQ.poll(); // 用砖
        			if(bricks<0) return i-1;  // 砖不足
        		}
        	}
        }
    	
    	return n-1;
    }
}