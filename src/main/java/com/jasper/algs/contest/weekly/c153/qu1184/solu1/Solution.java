package com.jasper.algs.contest.weekly.c153.qu1184.solu1;

/**
 * 1184. 公交站间的距离
 * 
 * <p> 简单实现
 */
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    	
    	int total = 0;
        for (int i = 0; i < distance.length; i++) {
			total += distance[i];
		}
        
        // 确保 start <= destination
        if(start > destination) {
        	start = start ^ destination;
        	destination = start ^ destination;
        	start = start ^ destination;
        	
        }
        
        // 顺时针距离
        int ans = 0;
        for (int i = start; i < destination; i++) {
			ans += distance[i];
		}
        
        return Math.min(ans, total-ans);
    }
}