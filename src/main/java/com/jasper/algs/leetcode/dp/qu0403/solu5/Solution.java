package com.jasper.algs.leetcode.dp.qu0403.solu5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 0403. 青蛙过河
 * 
 * <p> 动态规划
 */
class Solution {
    public boolean canCross(int[] stones) {
    	int n = stones.length;
    	// 动态规划 （stone[i], k）
    	Map<Integer,Set<Integer>> dp = new HashMap<Integer, Set<Integer>>();
    	for (int i = 0; i < n; i++) 
			dp.put(stones[i], new HashSet<Integer>());
    	
    	// 跳 0 个 单位到第 0 个石头
		dp.get(0).add(0);
		
		for (int i = 0; i < n; i++) {
			// 第 i 个石头可达，则继续跳
			for (int k : dp.get(stones[i])) {
				// 跳到下一个石头
				for (int nk = k-1; nk <= k+1; nk++) {
					int nx = stones[i] + nk;
					if(nk > 0 && dp.containsKey(nx)) dp.get(nx).add(nk);
				}
			}
		}
		
    	return dp.get(stones[n-1]).size() > 0;
    }
}