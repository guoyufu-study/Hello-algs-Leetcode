package com.jasper.algs.leetcode.permutation.qu0047.solu;

import java.util.ArrayList;
import java.util.List;

/**
 * 0047. 全排列 II
 * 
 * <p> 2刷
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

    	return new ArrayList<List<Integer>>();
    }
	
	public static void main(String[] args) {
		
//		[
//		  [1,1,2],
//		  [1,2,1],
//		  [2,1,1]
//		]
//		int[] nums = new int[] { 1,1,2 };

		// [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
//		int[] nums = new int[] {2,2,1,1};
		
		int[] nums = new int[] {-1,2,-1,2,1,-1,2,1};
		
		System.out.println(new Solution().permuteUnique(nums));
	}
}