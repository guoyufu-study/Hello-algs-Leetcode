package com.jasper.algs.leetcode.greedy.qu0717.solu1;

/**
 * 0717. 1比特与2比特字符
 * 
 * <p> 线性扫描
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
    	int n = bits.length, i = 0;
    	 while (i < n - 1) {// i 指向每个比特的首字符
    		 // 遇 0, +1
    		 // 遇 1， +2
             i += bits[i] + 1;
         }
    	 // i 最终是否落到 n-1 的位置
    	return i == n-1;
    }
}