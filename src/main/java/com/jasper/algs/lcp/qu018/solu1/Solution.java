package com.jasper.algs.lcp.qu018.solu1;

import java.util.Arrays;

/**
 * LCP 18. 早餐组合
 * 
 * <p> 排序 + 二分查找
 */
class Solution {
    private static final long MOD = 1_000_000_007;
	public int breakfastNumber(int[] staple, int[] drinks, int x) {
    	int n = staple.length, m = drinks.length;
    	// 排序
    	Arrays.sort(drinks);
    	long ans = 0;
    	for (int i = 0; i < n; i++) {
			if(x <= staple[i]) continue;
			// 二分查找
			int rest = x - staple[i];
			int left = 0, right = m-1;
			while(left <= right) {
				int mid = (left + right) / 2;
				if(drinks[mid] <= rest) left = mid + 1;
				else right = mid - 1;
			}
			
			// 累加统计
			ans += left;
		}
    	return (int)(ans % MOD);
    }
}