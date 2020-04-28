package com.jasper.algs.leetcode.hashmap.qu1103.solu2;

/**
 * 1103. 分糖果 II
 * 
 * <p>等差数列求和
 */
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
    	 int n = num_people;
	    // 有多少人次收到了完整礼物
	    int p = (int)(Math.sqrt(2 * candies + 0.25) - 0.5);
	    // 最后剩余多少糖果
	    int remaining = (int)(candies - (p + 1) * p * 0.5);
	    // 完整回合数
	    int rows = p / n, 
	    // 不完整回合，有多少人次收到了完整礼物
	    	cols = p % n;

	    int[] ans = new int[n];
	    for(int i = 0; i < n; ++i) {
	      // 完整回合
	      ans[i] = (i + 1) * rows + (int)(rows * (rows - 1) * 0.5) * n;
	      // 不完整回合，分到完整礼物
	      if (i < cols) ans[i] += i + 1 + rows * n;
	    }
	    // 剩余糖果   
	    ans[cols] += remaining;
	    return ans;

    }
}