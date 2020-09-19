package com.jasper.algs.contest.weekly.c097.qu0887.solu4;

/**
 * 0887. 鸡蛋掉落
 * 
 * <p> 动态规划  + 数学
 */
class Solution {
	public int superEggDrop(int K, int N) {     
        int[] dp = new int[K+1];
        int x = 1;
        while (true){
            for (int i = K; i > 0; --i) {
                dp[i] += dp[i-1]+1;
            }
            if (dp[K] >= N) break;
            x++;
        }
        return x;
    }
}