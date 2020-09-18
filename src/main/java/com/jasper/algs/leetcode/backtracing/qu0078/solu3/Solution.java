package com.jasper.algs.leetcode.backtracing.qu0078.solu3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0078. 子集
 * 
 * <p> 逐个增加长度：迭代
 */
class Solution {
	
	List<List<Integer>> ans;
	int[] nums;
	int n, len;
	public List<List<Integer>> subsets(int[] nums) {
		ans = new ArrayList<List<Integer>>();
		this.nums = nums;
		n = nums.length;

		for (len = 0; len <= n; len++) {
			dfs(0, new ArrayList<Integer>());
		}
    	return ans;
    }
	
	void dfs(int start, List<Integer> memo) {
		if(memo.size()==len) {
			ans.add(new LinkedList<Integer>(memo));
			return ;
		}
		for (int index = start; index < n; index++) {
			memo.add(nums[index]);
			dfs(index+1, memo);
			memo.remove(memo.size()-1);
		}
	}

}