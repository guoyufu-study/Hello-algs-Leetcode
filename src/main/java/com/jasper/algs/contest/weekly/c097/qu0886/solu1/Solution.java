package com.jasper.algs.contest.weekly.c097.qu0886.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0886. 可能的二分法
 * 
 * <p> 二分图
 */
class Solution {
	
	List<Integer>[] graph;
	int[] colors;
	
	@SuppressWarnings("unchecked")
	public boolean possibleBipartition(int N, int[][] dislikes) {
		// 构造图
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int[] edge : dislikes) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		
		// 染色
		colors = new int[N+1];
		for (int node = 1; node <= N; node++) {
			if(colors[node]==0 && !dfs(node, 1)) // 未染色 且 染色未成功
				return false;
		}
		
        return true;
    }

	private boolean dfs(int node, int color) {
		// 已染色
		if(colors[node]!=0)
			return colors[node]==color;
			
		// 染色给定节点
		colors[node] = color;
		
		// 染色邻接节点
		for(int adj : graph[node]) {
			if(!dfs(adj, -color)) return false;
		}
		return true;
	}
}