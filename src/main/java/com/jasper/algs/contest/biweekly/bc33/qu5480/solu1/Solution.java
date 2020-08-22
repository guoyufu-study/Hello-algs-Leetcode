package com.jasper.algs.contest.biweekly.bc33.qu5480.solu1;

import java.util.LinkedList;
import java.util.List;

/**
 * 5480. 可以到达所有点的最少点数目
 * 
 * <p> 统计入度
 */
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

    	int[] indegrees = new int[n];
    	for (List<Integer> edge : edges) {
			indegrees[edge.get(1)]++;
		}
    	
    	LinkedList<Integer> ans = new LinkedList<Integer>();
    	for (int i = 0; i < n; i++) {
			if(indegrees[i]==0) 
				ans.add(i);
		}
    	
    	return ans;
    }
}