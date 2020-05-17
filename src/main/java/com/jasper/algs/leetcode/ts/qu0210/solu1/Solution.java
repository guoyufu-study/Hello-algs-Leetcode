package com.jasper.algs.leetcode.ts.qu0210.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 0210.课程表 II
 * 
 * <p>
 * DAG 拓朴排序：BFS
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	
    	// 邻接表 u -> v1,v2...
    	List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
    	for (int i = 0; i < numCourses; i++)
    		adjacency.add(new ArrayList<Integer>());
    	// 入度表 v -> count(u)
    	int[] inDegree = new int[numCourses];
    	
    	// 填充邻接表和入度表
    	for (int[] cp : prerequisites) {
			inDegree[cp[0]]++;
			adjacency.get(cp[1]).add(cp[0]);
		}
    	
    	// 起始候选队列
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < numCourses; i++) {
			if(inDegree[i]==0) 
				queue.add(i);
		}
    	
    	// 拓朴排序
    	int[] ans = new int[numCourses];
    	Arrays.fill(ans, -1);
    	int i = 0;
    	while(!queue.isEmpty()) {
    		int u = queue.poll();
    		List<Integer> list = adjacency.get(u);
    		for (int v : list) {
				if(--inDegree[v]==0) 
					queue.add(v);
			}
    		ans[i++] = u;
    	}
    	
    	if(ans[numCourses-1]==-1) // 有环
    		return new int[0];
    	// DAG
    	return ans;
    }

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = new int[][] { { 1, 0 } };

		IntStream.of(new Solution().findOrder(numCourses, prerequisites))
			.mapToObj(i -> i + " ")
			.forEach(System.out::print);
	}
}