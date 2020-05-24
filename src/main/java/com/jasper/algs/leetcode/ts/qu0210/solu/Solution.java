package com.jasper.algs.leetcode.ts.qu0210.solu;

import java.util.stream.IntStream;

/**
 * 0210.课程表 II
 * 
 * <p> 二刷
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	
    	return new int[0];
    }

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = new int[][] { { 1, 0 } };

		IntStream.of(new Solution().findOrder(numCourses, prerequisites))
			.mapToObj(i -> i + " ")
			.forEach(System.out::print);
	}
}