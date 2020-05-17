package com.jasper.algs.leetcode.ts.qu0207.solu1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0207. 课程表
 * 
 * <p>
 * DAG 拓朴排序：BFS
 */
class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		// 构造邻接表
		List<List<Integer>> adjacency = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			adjacency.add(new ArrayList<>());
		// 构造入度表
		int[] indegrees = new int[numCourses];
		// 填充入度表和邻接表
		for (int[] cp : prerequisites) {
			indegrees[cp[0]]++;
			adjacency.get(cp[1]).add(cp[0]);
		}
		// 所有入度为0的课程，作为起始候选项
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++)
			if (indegrees[i] == 0)
				queue.add(i);
		
		// BFS 拓朴排序.
		while (!queue.isEmpty()) {
			// 起始点
			int pre = queue.poll();
			// 计数
			numCourses--;
			// 所有邻接点入度减1。如果入度为0，则入栈作为起始候选项
			for (int cur : adjacency.get(pre))
				if (--indegrees[cur] == 0)
					queue.add(cur);
		}
		
		return numCourses == 0;
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = new int[][] { { 1, 0 } };

		System.out.println(new Solution().canFinish(numCourses, prerequisites));
	}
}