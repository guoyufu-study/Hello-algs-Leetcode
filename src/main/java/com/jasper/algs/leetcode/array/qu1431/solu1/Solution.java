package com.jasper.algs.leetcode.array.qu1431.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 * 
 * <p> 求最大值
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    	
    	int N = candies.length;

    	// 找出最大值
    	int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, candies[i]);
			candies[i] += extraCandies;
		}
		
		// 构造答案
		List<Boolean> ans = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ans.add(candies[i]>=max);
		}
		
    	return ans;
    }
}
