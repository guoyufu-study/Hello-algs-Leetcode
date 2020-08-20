package com.jasper.algs.leetcode.dp.qu0096.solu2;

/**
 * 0096. 不同的二叉搜索树
 * 
 * <p> 卡特兰数
 */
class Solution {
    public int numTrees(int n) {
    	long ans = 1;
    	for (int i = 0; i < n; i++) {
			ans = ans * 2 * (2 * i + 1) / (i + 2);
		}
    	return (int)ans;
    }
}