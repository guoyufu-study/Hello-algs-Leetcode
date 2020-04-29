package com.jasper.algs.leetcode.permutation.qu0046.solu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 0046 全排列
 * 
 * <p>
 * 回溯法
 */
class Solution {
	public List<List<Integer>> permute(int[] nums) {
		
		// 辅助输出
		List<Integer> output = new ArrayList<Integer>();
		for (int num : nums) output.add(num);
		
		List<List<Integer>> ans = new ArrayList<>();
		
		// 回溯
		backtrack(nums.length, output, ans, 0);
		
		return ans;
	}
	
	/**
	 * 回溯法全排列
	 * 
	 * @param n 数组长度
	 * @param output 辅助输出列表
	 * @param memo	记录全排列
	 * @param first 当前要排列的位置索引
	 */
	private void backtrack(int n, List<Integer> output, List<List<Integer>> memo, int first) {
		// 所有数都填完了
		if (first == n)
			memo.add(new ArrayList<Integer>(output));
		
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(output, first, i);
			// 继续递归填下一个数
			backtrack(n, output, memo, first + 1);
			// 撤销操作
			Collections.swap(output, first, i);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		System.out.println(new Solution().permute(nums));
	}
}