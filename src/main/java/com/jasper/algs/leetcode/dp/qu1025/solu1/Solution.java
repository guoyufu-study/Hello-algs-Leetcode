package com.jasper.algs.leetcode.dp.qu1025.solu1;

/**
 * 1025. 除数博弈
 *
 * <p> 归纳法：偶数一定赢，奇数一定输
 */
class Solution {
    public boolean divisorGame(int N) {

    	return (N & 1) == 0;
    }
}