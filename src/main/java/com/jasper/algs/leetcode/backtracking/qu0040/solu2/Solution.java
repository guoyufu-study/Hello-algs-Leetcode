package com.jasper.algs.leetcode.backtracking.qu0040.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0040. 组合总和 II
 * 
 * <p> 回溯法+去重+剪枝 <= 加法
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	
    	// 排序：方便去重和剪枝
    	Arrays.sort(candidates);
    	
    	// 回溯：加法
//    	dfs(candidates, candidates.length, target, -1, new LinkedList<Integer>(), ans);
    	
    	return ans;
    }

}