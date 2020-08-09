package com.jasper.algs.contest.weekly.c201.qu1505.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1505. 和为目标值的非空不重叠子数组最大数目
 * 
 * <p> 动态规划 + 前缀和字典
 */
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
    	
    	int n = nums.length;
		int[] dp = new int[n+1];
		dp[0] = 0;
		Map<Long,Integer> map = new HashMap<>(n+1);
		map.put(0L, 0);
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i-1];
			sum += nums[i-1];
			if(map.containsKey(sum-target)) {
				dp[i] = Math.max(dp[i], dp[map.get(sum-target)]+1);
			}
			
			map.put(sum, i);
		}
    	return dp[n];
    }
    
    public static void main(String[] args) {
    	// 2
//    	int[] nums = new int[] {1,1,1,1,1};
//    	int target = 2;
    	
    	// 2
//    	int[] nums = new int[] {-1,3,5,1,4,2,-9};
//    	int target = 6;
    	
    	// 3
//    	int[] nums = new int[] {-2,6,6,3,5,4,1,2,8};
//    	int target = 10;
    	
    	// 3
    	int[] nums = new int[] {0,0,0};
    	int target = 0;
    	
    	System.out.println(new Solution().maxNonOverlapping(nums, target));
	}
}