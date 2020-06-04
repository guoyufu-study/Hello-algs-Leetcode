package com.jasper.algs.leetcode.permutation.qu0047.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 0047. 全排列 II
 * 
 * <p> 
 */
class Solution {
	
	private int n;
	private boolean[] selected;
	private List<Integer> path;
	private List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {

    	Arrays.sort(nums);
    	n = nums.length;
    	selected = new boolean[n];
    	path = new ArrayList<Integer>(n);
    	ans = new ArrayList<List<Integer>>();

    	// 回溯
    	backtracing(nums, 0);
    	
    	return ans;
    }
	
	private void backtracing(int[] nums, int count) {
		if(n==count) {
			ans.add(new ArrayList<Integer>(path));
			return ;
		}
		
		HashMap<Integer, Boolean> prev = new HashMap<Integer, Boolean>();
		for (int i = 0; i < nums.length; i++) {
			// 剪枝
			if(selected[i] || // 已选元素
					prev.getOrDefault(nums[i], false)) // 重复元素
				continue;
			
			// 选择
			path.add(nums[i]);
			selected[i] = true;
			prev.put(nums[i], true);
			
			// 下一个
			backtracing(nums, count+1);
			
			// 回溯
			path.remove(count);
			selected[i] = false;
		}
	}

	public static void main(String[] args) {
		
//		[
//		  [1,1,2],
//		  [1,2,1],
//		  [2,1,1]
//		]
//		int[] nums = new int[] { 1,1,2 };

//		[
//		 	[1,1,2,2],
//		 	[1,2,1,2],
//		 	[1,2,2,1],
//		 	[2,1,1,2],
//		 	[2,1,2,1],
//		 	[2,2,1,1]
//		]
//		int[] nums = new int[] {2,2,1,1};
		
		int[] nums = new int[] {-1,2,-1,2,1,-1,2,1};
		
		System.out.println(new Solution().permuteUnique(nums));
	}
}