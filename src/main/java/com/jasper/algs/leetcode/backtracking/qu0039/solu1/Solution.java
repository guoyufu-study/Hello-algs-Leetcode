package com.jasper.algs.leetcode.backtracking.qu0039.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 0039. 组合总和
 * 
 * <p> 回溯法+去重+剪枝
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	int N = candidates.length;
    	
    	// 排序是为了提前终止搜索
    	Arrays.sort(candidates);
    	
    	// 回溯：减法
		dfs(candidates, N, target, 0, new LinkedList<Integer>(), ans);
    	
    	return ans;
    }

    /**
     * DFS 深度优先搜索
     * 
     * @param candidates	输入数组
     * @param N				输入数组的长度，冗余变量
     * @param target		目标和
     * @param prev			本轮搜索的起点下标
     * @param path			路径
     * @param ans			结果集
     */
	private void dfs(int[] candidates, int N, int target, int prev, Deque<Integer> path, List<List<Integer>> ans) {
		
		if(target==0) {
			// 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
			ans.add(new ArrayList<>(path));
			return ;
		}
		
		// 路径点非递减，去重
		for (int i = prev; i < N; i++) { 
			// 在数组有序的前提下，剪枝提速
			if(target - candidates[i]<0) break;
			
			// 记录路径
			path.add(candidates[i]);
			// 选择下一个路径点
			dfs(candidates, N, target-candidates[i], i, path, ans);
			// 回溯
			path.removeLast();
		}
	}
}