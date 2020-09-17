package com.jasper.algs.lcp.qu018.solu2;

import java.util.Arrays;

/**
 * LCP 18. 早餐组合
 * 
 * <p> 排序 + 左右指针
 */
class Solution {
    private static final long MOD = 1_000_000_007;
	public int breakfastNumber(int[] staple, int[] drinks, int x) {
    	int n = staple.length,  last = n;
    	
    	// 排序
    	Arrays.sort(staple);
    	Arrays.sort(drinks);
    	
    	// 左右指针
    	long ans = 0;
    	for (int drink : drinks) {
			if(x <= drink || last==0) break;
    		int rest = x - drink;
    		while(last > 0 && staple[last-1] > rest) last--;
    		ans += last;
		}
    	return (int)(ans % MOD);
    }
}