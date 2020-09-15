package com.jasper.algs.interview.qu0401.solu2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 04.01. 节点间通路
 * 
 * <p>
 * 邻接表 + BFS
 */
class Solution {
	@SuppressWarnings("unchecked")
	public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

		if (start == target)
			return true;
		// 邻接表
		List<Integer>[] adjs = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adjs[i] = new ArrayList<Integer>();
		for (int[] edge : graph) {
			adjs[edge[0]].add(edge[1]);
		}

		// 标记可达
		boolean[] marked = new boolean[n];
		marked[start] = true;
		// BFS
		Deque<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int adj : adjs[tmp]) {
				if (!marked[adj]) {
					queue.offer(adj);
					if (adj == target)
						return true;
				}
			}
		}

		return false;
	}

}
