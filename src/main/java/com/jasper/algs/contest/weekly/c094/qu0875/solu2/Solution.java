package com.jasper.algs.contest.weekly.c094.qu0875.solu2;

import java.util.Arrays;

/**
 * 0875. 爱吃香蕉的珂珂
 * 
 * <p> 数学（用例不全，超时）
 */
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
    	// 求和
    	int ans = (int) -Math.floorDiv(-Arrays.stream(piles).asLongStream().sum(), H);
    	// 逐一检测
    	while(true) {
    		int tmp = 0;
    		for (int pile : piles) {
				tmp += -Math.floorDiv(pile, ans);
			}
    		if(tmp <= H) return ans;
    		ans++;
    	}
    }
}