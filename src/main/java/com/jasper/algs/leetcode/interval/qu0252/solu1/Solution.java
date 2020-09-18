package com.jasper.algs.leetcode.interval.qu0252.solu1;

import java.util.Arrays;

/**
 * 0252. 会议室
 * 
 * <p> 排序 + 区间比较
 */
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        // 排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        // 比较起始时间
        int n = intervals.length;
        for(int i=0; i+1<n; i++) {
            if(intervals[i][1] > intervals[i+1][0]) 
                return false;
        }

        return true;
    }
}