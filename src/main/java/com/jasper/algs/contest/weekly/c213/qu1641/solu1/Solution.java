package com.jasper.algs.contest.weekly.c213.qu1641.solu1;

/**
 * 1641. 统计字典序元音字符串的数目
 * 
 * <p> 动态规划（递推）
 */
class Solution {
    public int countVowelStrings(int n) {
    	int a = 1, e = 1, i = 1, o = 1, u = 1;
    	for(int count=2; count<=n; count++) {
    		e += a;
    		i += e;
    		o += i;
    		u += o;
    	}
    	return a+e+i+o+u;
    }
}