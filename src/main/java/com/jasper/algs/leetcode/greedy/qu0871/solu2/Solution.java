package com.jasper.algs.leetcode.greedy.qu0871.solu2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 0871. 最低加油次数
 * 
 * <p> 贪心算法
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
    	if(startFuel>=target) 
    		return 0;
    	
    	int ans = 0;
    	
    	// 大顶堆
    	PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    	int tank = startFuel;//一箱量
    	int prev = 0;// 前一位置
    	for (int[] station : stations) {
			int location = station[0];//位置
			int capacity = station[1];//容量
			
			tank -= location-prev; // 耗油
			
			// 提前加油
			while(!maxQueue.isEmpty() && tank<0) {
				tank += maxQueue.poll();
				ans++;
			}
			
			// 无法到达此站点
			if(tank<0) return -1;
			
			// 记录此站点
			maxQueue.offer(capacity);
			prev = location;
		}
    	
    	// 到达target
    	
		tank -= target-prev; // 耗油
		//提前加油
		while(!maxQueue.isEmpty() && tank<0) {
			tank += maxQueue.poll();
			ans++;
		}
		
    	return tank<0 ? -1 : ans;
    }
    
    public static void main(String[] args) {
    	// 0
//		int target = 1;
//		int startFuel = 1;
//		int[][] stations = new int[][] {};
		
		// -1
//		int target = 100;
//		int startFuel = 1;
//		int[][] stations = new int[][] {{10,100}};
		
		// 2
		int target = 100;
		int startFuel = 10;
		int[][] stations = new int[][] {{10,60},{20,30},{30,30},{60,40}};
		
		System.out.println(new Solution().minRefuelStops(target, startFuel, stations));
	}
}