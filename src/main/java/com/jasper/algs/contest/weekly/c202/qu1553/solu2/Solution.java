package com.jasper.algs.contest.weekly.c202.qu1553.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 1553. 吃掉 N 个橘子的最少天数
 * 
 * <p> 动态规划：离散
 */
class Solution {
	
	private static final Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
	static {
		dp.put(0, 0);
		dp.put(1, 1);
	}
	
    public int minDays(int n) {
    	
    	if(dp.containsKey(n))
    		return dp.get(n);
    	
    	int ans = Math.min(minDays(n/2) + n%2 + 1, minDays(n/3) + n%3 + 1);
    	dp.put(n, ans);
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 29
		int n = 61455274;
		
		System.out.println(new Solution().minDays(n));
	}
}