package com.jasper.algs.contest.weekly.c213.qu1642.solu1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1642. 可以到达的最远建筑
 * 
 * <p> 贪心算法：先砖后梯
 */
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int i=1; i<n; i++) {
        	int h = heights[i] - heights[i-1];
        	if(h>0) {
        		bricks -= h; // 先用砖
        		maxQ.offer(h);
        		if(bricks<0) {// 砖不足
        			if(ladders==0) return i-1; // 无梯
        			// 替换成梯子
    				bricks += maxQ.poll();
    				--ladders;
        			
        		}
        	}
        }
    	
    	return n-1;
    }
}