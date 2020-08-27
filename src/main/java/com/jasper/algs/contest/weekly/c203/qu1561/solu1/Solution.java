package com.jasper.algs.contest.weekly.c203.qu1561.solu1;

import java.util.Arrays;

/**
 * 1561. 你可以获得的最大硬币数目
 * 
 * <p> 排序 + 贪心
 */
class Solution {
    public int maxCoins(int[] piles) {
    	
    	// 排序
        Arrays.sort(piles);

        // 贪心取第二大
        int len = piles.length, n = len/3;
        int ans = 0;
        for(int i=n; i< len; i+=2) {
            ans += piles[i];
        }

        return ans;
    }
}