package com.jasper.algs.leetcode.dp.qu0416.solu;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 0416. 分割等和子集
 * 
 * <p> 2刷
 */
class Solution {
    public boolean canPartition(int[] nums) {

    	return false;
    }
    
    public static void main(String[] args) {
		int[][] nums = new int[][] {
			{1, 5, 11, 5}, // true
			{1, 2, 3, 5}, // false
		};
		
		Arrays.stream(nums)
			.map(new Solution()::canPartition)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}