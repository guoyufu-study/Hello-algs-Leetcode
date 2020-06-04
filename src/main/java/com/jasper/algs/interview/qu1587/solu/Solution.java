package com.jasper.algs.interview.qu1587.solu;

import java.util.stream.IntStream;

/**
 * 1587. 面试题 17.19. 消失的两个数字
 * 
 * <p> 2刷
 */
class Solution {
    public int[] missingTwo(int[] nums) {
    	int[] ans = new int[2];
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// [2,3]
		int[] nums = new int[] {1};
		
		// [1,4]
//		int[] nums = new int[] {2,3};
		
		IntStream.of(new Solution().missingTwo(nums))
			.forEach(x -> System.out.print(x + ","));
	}
}