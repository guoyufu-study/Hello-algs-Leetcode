package com.jasper.algs.leetcode.backtracing.qu0078.solu1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0078. 子集
 * 
 * <p> 逐个添加元素：回溯
 */
class Solution {
	
	List<List<Integer>> ans;
	int[] nums;
	int n;
	public List<List<Integer>> subsets(int[] nums) {
    	ans = new ArrayList<List<Integer>>();
    	this.nums = nums;
    	n = nums.length;
    	
    	dfs(n-1, new LinkedList<>());
    	
    	return ans;
    }

	private void dfs(int index, List<Integer> memo) {
		if(index==-1) {
			ans.add(new LinkedList<Integer>(memo));
			return ;
		}
        // 不添加
		dfs(index-1, memo);

        // 添加
		memo.add(0, nums[index]);
		dfs(index-1, memo);
        memo.remove(0);
	}
}