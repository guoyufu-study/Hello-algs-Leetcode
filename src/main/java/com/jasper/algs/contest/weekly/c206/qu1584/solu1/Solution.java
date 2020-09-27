package com.jasper.algs.contest.weekly.c206.qu1584.solu1;

import java.util.PriorityQueue;

/**
 * 1584. 连接所有点的最小费用
 * 
 * <p> 贪心算法
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
    	int ans = 0, n = points.length;
    	
    	// 连接两点的费用
    	PriorityQueue<int[]> costs = new PriorityQueue<int[]>((x, y) -> x[2]-y[2]);
    	for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				costs.offer(new int[] {i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
			}
		}
    	
    	// 合并连通块
    	int[] area = new int[n];
    	for(int i=0; i<n; i++) area[i] = i;
		while(!costs.isEmpty()) {
			int[] cost = costs.poll();
			if(area[cost[0]] == area[cost[1]]) continue;
			else {
				int target = area[cost[0]];
				for(int j=0; j<n; j++) {
					if(area[j]==target) area[j]= area[cost[1]];
				}
				
				ans += cost[2];
			}
		}
    	
    	return ans;
    }
    
}