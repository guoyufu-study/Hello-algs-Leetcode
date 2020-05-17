package com.jasper.algs.leetcode.greedy.qu0630.solu1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 0630. 课程表 III
 *
 * <p> 贪心算法+优先级队列
 */
class Solution {
    public int scheduleCourse(int[][] courses) {

    	// 按照完成时间 d 递增排序
    	Arrays.sort(courses, (a, b) -> {
    		return a[1]-b[1];
    	});
    	
    	// 已选课结束时间
    	int sum = 0;
    	// 最大堆
    	PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
    		return b[0] - a[0];
    	});
    	for (int i = 0; i < courses.length; i++) {
    		// 要选的课程
    		int[] course = courses[i];
    		// 可直接选
			if(sum+course[0]<=course[1]) {
				sum += course[0];
				queue.add(course);
			} 
			// 不可直接选，但可替换
			else if(!queue.isEmpty() && queue.peek()[0]>course[0]) {
				sum += course[0] - queue.poll()[0];
				queue.add(course);
			}
			// 不可直接选，也不可替换，无动作
		}
    	
    	return queue.size();
    }
}