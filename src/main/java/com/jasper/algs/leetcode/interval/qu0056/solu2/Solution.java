package com.jasper.algs.leetcode.interval.qu0056.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        List<int[]> ans = new ArrayList<>();
        
        // 合并
        int[] pre = intervals[0];
        pre = intervals[intervals.length - 1];
        for (int i = intervals.length - 2; i >= 0; i--) {
            if (pre[0] > intervals[i][1]) {
                ans.add(pre);
                pre = intervals[i];
            } else {
                pre[0] = Math.min(pre[0], intervals[i][0]);
            }
        }
        
        ans.add(pre);
        
        return ans.toArray(new int[ans.size()][]);
    }
    
}