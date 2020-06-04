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
		List<Integer> path = new ArrayList<Integer>();
		for (int num : nums) path.add(num);
		
		List<List<Integer>> ans = new ArrayList<>();
		
		// 回溯
		backtrack(nums.length, path, ans, 0);
		
		return ans;
	}
	
	/**
	 * 回溯法全排列
	 * 
	 * @param n 数组长度
	 * @param path 辅助输出列表
	 * @param memo	记录全排列
	 * @param first 当前要排列的位置索引
	 */
	private void backtrack(int n, List<Integer> path, List<List<Integer>> memo, int first) {
		// 所有数都填完了
		if (first == n)
			memo.add(new ArrayList<Integer>(path));
		
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(path, first, i);
			// 继续递归填下一个数
			backtrack(n, path, memo, first + 1);
			// 撤销操作
			Collections.swap(path, first, i);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };

		System.out.println(new Solution().permute(nums));
	}
}