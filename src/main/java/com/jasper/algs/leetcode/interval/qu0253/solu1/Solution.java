package com.jasper.algs.leetcode.interval.qu0253.solu1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 0253. 会议室 II
 * 
 * <p> 优先队列
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if(n==0) return 0;
        
        // 排序：开始时间
        Arrays.sort(intervals, (x, y) -> x[0]-y[0]);
        // 优先级队列：结束时间
        PriorityQueue<Integer> queue = new PriorityQueue<>(n);
        
        // 模拟
        for (int[] interval : intervals) {
			if(!queue.isEmpty() && queue.peek() <= interval[0]) { // 腾出会议室
				queue.poll();
			}
			queue.offer(interval[1]); // 占用会议室
		}
        
        return queue.size();
    }
}