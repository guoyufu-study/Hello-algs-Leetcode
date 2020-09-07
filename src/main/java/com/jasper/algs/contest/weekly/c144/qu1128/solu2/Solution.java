package com.jasper.algs.contest.weekly.c144.qu1128.solu2;

/**
 * 1128. 等价多米诺骨牌对的数量
 * 
 * <p> 辅助数组 + hash
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
    	int n = dominoes.length;
    	int[] helper = new int[100];
    	for (int i = 0; i < n; i++) {
			int index = dominoes[i][0] <= dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1] : dominoes[i][1] * 10 + dominoes[i][0];
			helper[index]++;
		}
    	
    	int ans = 0;
    	for (int i = 0; i < 100; i++) {
			ans += helper[i] * (helper[i]-1) / 2;
		}
    	return ans;
    }
}