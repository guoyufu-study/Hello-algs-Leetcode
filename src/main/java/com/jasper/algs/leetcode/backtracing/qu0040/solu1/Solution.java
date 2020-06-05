package com.jasper.algs.leetcode.backtracing.qu0040.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 0040. 组合总和 II
 * 
 * <p> 回溯法+去重+剪枝 <= 减法
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	int N = candidates.length;
    	
    	// 排序：方便去重和剪枝
    	Arrays.sort(candidates);
    	// 回溯：减法
    	dfs(candidates, N, target, -1, new LinkedList<Integer>(), ans);
    	
    	return ans;
    }

	private void dfs(int[] candidates, int N, int target, int prev, Deque<Integer> path, List<List<Integer>> ans) {
		
		// 终止条件
		if(target==0) {
			ans.add(new ArrayList<Integer>(path));
			return ;
		}
		
		for (int i = prev+1; i < N; i++) {
			// 小剪枝去重：跳过重复元素
			if(i>prev && candidates[i]==candidates[i-1]) continue;
			// 大剪枝
			if(target-candidates[i]<0) break;
			
			// 记录路径
			path.add(candidates[i]);
			// 选择下一路径点
			dfs(candidates, N, target-candidates[i], i, path, ans);
			// 回溯路径
			path.removeLast();
		}
		
	}
}