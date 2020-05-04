package com.jasper.algs.leetcode.sorting.qu0056.solu1;

import java.util.Arrays;

/**
 * 0056. 合并区间
 * 
 * <p>排序，合并
 */
class Solution {
    public int[][] merge(int[][] intervals) {
    	
    	// 边界 []
    	if(intervals==null || intervals.length<=1)
    		return intervals;
    	
    	// 排序
    	Arrays.sort(intervals, (o1, o2) -> {
    		return o1[0] - o2[0];
    	});
    
    	// 合并
    	int[][] ans = new int[intervals.length][2];
    	int k = 0;
    	ans[k] = intervals[0];
    	for (int i = 1; i < intervals.length; i++) {
			if(ans[k][1] >= intervals[i][0])
				// [[1,4],[2,3]]
				ans[k][1] = Math.max(ans[k][1], intervals[i][1]);
			else {
				ans[++k] = intervals[i];
			}
		}
    	
    	return Arrays.copyOf(ans, k+1);
    }
    
    
}