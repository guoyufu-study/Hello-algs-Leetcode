package com.jasper.algs.contest.weekly.c213.qu1641.solu2;

/**
 * 1641. 统计字典序元音字符串的数目
 * 
 * <p> 组合计数
 */
class Solution {
    public int countVowelStrings(int n) {
    	return (n+4)*(n+3)*(n+2)*(n+1) / 24;
    }
}