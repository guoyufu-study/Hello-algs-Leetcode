package com.jasper.algs.leetcode.permutation.qu0046.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0046 全排列
 * 
 * <p>
 * 回溯法
 */
class Solution {
	
	private int n;
	// 标记已选择
	private boolean[] selected;
	// 记录路径
	private List<Integer> path;
	private List<List<Integer>> ans;
	
	public List<List<Integer>> permute(int[] nums) {
		
		n = nums.length;
		selected = new boolean[n];
		path = new ArrayList<Integer>();
		ans = new ArrayList<>();
		
		// 回溯
		backtrack(nums, 0);
		
		return ans;
	}
	
	/**
	 * 回溯法全排列
	 */
	private void backtrack(int[] nums, int count) {
		// 所有数都填完了
		if (count == n) {
			ans.add(new ArrayList<Integer>(path));
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			// 剪枝：跳过已选
			if(selected[i]) continue; 
			
			// 标记选择
			selected[i] = true;
			
			// 记录选择
			path.add(nums[i]);
			
			// 选择下一个数
			backtrack(nums, count+1);
			
			// 回溯
			path.remove(count);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		System.out.println(new Solution().permute(nums));
	}
}