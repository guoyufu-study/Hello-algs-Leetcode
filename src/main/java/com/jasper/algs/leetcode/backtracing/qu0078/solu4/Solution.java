package com.jasper.algs.leetcode.backtracing.qu0078.solu4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0078. 子集
 * 
 * <p> 二进制排序
 */
class Solution {
	
	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		int max = 1 << n;
		for (int mask = 0; mask < max; mask++) {
			// 长度为 n 的二进制位掩码
//			String bitmask = Integer.toBinaryString(mask | max).substring(1);
			
			// 位掩码 -> 子集
			List<Integer> tmp = new LinkedList<Integer>();
//			for (int j = 0; j < n; j++) 
//				if(bitmask.charAt(j)=='1') tmp.add(nums[j]);
			
			for (int j = 0; j < n; ++j)
				if ((mask & (1 << j)) != 0) tmp.add(nums[j]);
	                	
			ans.add(tmp);
		}
		
    	return ans;
    }
}