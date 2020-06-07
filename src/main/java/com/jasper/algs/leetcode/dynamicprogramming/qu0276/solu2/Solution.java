package com.jasper.algs.leetcode.dynamicprogramming.qu0276.solu2;

/**
 * 0276. 栅栏涂色
 * 
 * <p> 动态规划：状态压缩
 */
class Solution {
    public int numWays(int n, int k) {
    	// 边界
    	if(n==0) return 0; // 无栅栏
    	if(n==1) return k; // 1 栅栏
    	
    	// 动态规划
    	int ans = k*k;
    	int prev = k;
    	for (int i = 3; i <= n; i++) {
			int tmp = (k-1) * (ans + prev); 
			prev = ans;
			ans = tmp;
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 6
    	int n = 3;
    	int k = 2;
		
    	// 1
//    	int n = 2;
//    	int k = 1;
    	
    	// 0
//    	int n = 3;
//    	int k = 1;
    	
    	// 10
//    	int n = 4;
//    	int k = 2;
    	
		System.out.println(new Solution().numWays(n, k));
	}
}