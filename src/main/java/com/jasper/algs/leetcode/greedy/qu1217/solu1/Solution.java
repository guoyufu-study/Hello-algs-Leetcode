package com.jasper.algs.leetcode.greedy.qu1217.solu1;

/**
 * 1217. 玩筹码
 *
 * <p> 计数奇偶数
 */
class Solution {
    public int minCostToMoveChips(int[] chips) {
    	int N = chips.length;
    	
    	int odd = 0, even = 0;
		for (int i = 0; i < N; i++) {
			if(chips[i]%2==0) even++;
			else odd++;
		}
		
    	return Math.min(odd, even);
    }
}