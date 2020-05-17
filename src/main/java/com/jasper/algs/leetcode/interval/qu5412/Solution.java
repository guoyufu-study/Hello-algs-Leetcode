package com.jasper.algs.leetcode.interval.qu5412;

/**
 * 5412. 在既定时间点做作业的学生人数
 *
 */
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    	
    	int N = startTime.length;
    	int ans = 0;
    	for (int i = 0; i < N; i++) {
    		if(startTime[i] <= queryTime // 已开始作业
    				&&
    			queryTime <= endTime[i] // 未结束作业
    				)
    			ans++;
		}
    	
    	return ans;
    }
}