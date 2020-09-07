package com.jasper.algs.contest.weekly.c144.qu1128.solu3;

/**
 * 1128. 等价多米诺骨牌对的数量
 * 
 * <p> 辅助数组
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
    	int n = dominoes.length;
    	int[][] helper = new int[10][10];
    	for (int i = 0; i < n; i++) {
			helper[dominoes[i][0]][dominoes[i][1]]++;
		}
    	
    	int ans = 0;
    	for (int i = 0; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				int sum = helper[i][j] + helper[j][i];
				ans += sum * (sum-1) / 2;
			}
		}
    	
    	for (int i = 0; i < 10; i++) {
			ans += helper[i][i] * (helper[i][i] - 1) / 2;
		}
    	return ans;
    }
}