package com.jasper.algs.leetcode.backtracing.qu0216.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 0216. 组合总和 III
 * 
 * <p> 回溯法+去重+剪枝 <= 减法
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

    	List<List<Integer>> ans = new ArrayList<>();
    	dfs(k, n, 1, new LinkedList<Integer>(), ans);
    	
    	return ans;
    }

    /**
     * DFS
     * 
     * @param k			还可以选择几个元素
     * @param n			目标和
     * @param start		从哪个元素开始
     * @param path		缓存路径
     * @param ans		缓存路径集合
     */
	private void dfs(int k, int n, int start, Deque<Integer> path, List<List<Integer>> ans) {
		// 终止条件
		if(n==0 && k==0) {
			ans.add(new ArrayList<Integer>(path));
			return ;
		}
		
		for (int i = start; i <= 9; i++) {
			// 剪枝
			if(n<=0 || k<=0) break;
			
			// 记录路径
			path.add(i);
			// 下一个路径点
			dfs(k-1, n-i, i+1, path, ans);
			// 回溯
			path.removeLast();
		}
	}
}