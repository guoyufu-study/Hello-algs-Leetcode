package com.jasper.algs.leetcode.greedy.qu0717.solu2;

/**
 * 0717. 1比特与2比特字符
 * 
 * <p> 贪心算法
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
    	int n = bits.length, i = n-2;
    	// 找到 倒数第二个 0
    	 while (i>=0 && bits[i]==1) {
             i--;
         }
    	
    	// 计算两 0 之间 1 的个数
    	return (n-2 - i) % 2 == 0;
    }
}