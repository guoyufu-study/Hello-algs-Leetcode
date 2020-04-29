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
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		
		int n = nums.length;
		// 辅助选择
		boolean[] selected = new boolean[n];
		// 辅助输出
		List<Integer> output = new ArrayList<Integer>();
		
		// 回溯
		backtrack(nums, n, 0, selected, output, ans);
		
		return ans;
	}
	
	/**
	 * 回溯法全排列
	 * @param nums
	 * @param n
	 * @param count
	 * @param selected
	 * @param output
	 * @param memo
	 */
	private void backtrack(int[] nums, int n, int count, boolean[] selected, List<Integer> output, List<List<Integer>> memo) {
		// 所有数都填完了
		if (count == n) {
			memo.add(new ArrayList<Integer>(output));
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			// 跳过已选
			if(selected[i]) continue; 
			
			// 标记选择
			selected[i] = true;
			
			// 记录选择
			output.add(nums[i]);
			
			// 选择下一个数
			backtrack(nums, n, count+1, selected, output, memo);
			
			// 回溯
			output.remove(count);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		System.out.println(new Solution().permute(nums));
	}
}