package com.jasper.algs.leetcode.dp.qu0070.solu1;

/**
 * 暴力求解：
 * 
 * <p> 尝试所有可能的组合，成功+1
 */
class Solution {
    public int climbStairs(int n) {
    	if(n<=1) 
    		return n;
    	return climbStairs(0, n);
    }
    
    /**
     * @param i 当前位于第i层台阶
     * @param n 目标总共有n层台阶
     * @return 从第i层台阶开始爬楼，总共有几种方法
     */
    private int climbStairs(int i, int n) {
    	if(i > n)
    		return 0;
    	if(i == n)
    		return 1;
    	
    	return climbStairs(i+1, n) + climbStairs(i+2, n);
    }
    
    
    public static void main(String[] args) {
		int n = 4;
		System.out.println(new Solution().climbStairs(n ));
	}
}