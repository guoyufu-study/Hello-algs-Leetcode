package com.jasper.algs.leetcode.dp.qu1289.solu2;

/**
 * 1289. 下降路径最小和  II
 *
 * <p> 动态规划
 */
class Solution {
    public int minFallingPathSum(int[][] arr) {
    	
    	int N = arr.length;
    	if(N==1) return arr[0][0];
    	
    	for (int i = 1; i < N; i++) {
    		// 最小值、第二小值
    		int one = 0;
    		int two = 1;
    		if(arr[i-1][1]<arr[i-1][0]) {
    			one = 1;
    			two = 0;
    		}
			for (int k = 2; k < N; k++) {
				if(arr[i-1][k]<arr[i-1][two]) {
					two = k;
					if(arr[i-1][two]<arr[i-1][one]) {
						two = one;
						one = k;
					}
				}
			}
			
			// 动态规划
			for (int j = 0; j < N; j++) {
				arr[i][j] += j!=one? arr[i-1][one] : arr[i-1][two];
			}
		}
    	
    	// 构造答案
    	int ans = 100_000;
    	for (int j = 0; j < N; j++) {
			ans = Math.min(arr[N-1][j], ans);
		}
    	return ans;
    }

	public static void main(String[] args) {

		// 13
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		// -268
//		int[][] arr = new int[][] {
//				{-37, 51,-36, 34,-22},
//				{ 82,  4, 30, 14, 38},
//				{-68,-52,-92, 65,-85},
//				{-49, -3,-77,  8,-19},
//				{-60,-71,-21,-62,-73}
//			} ;

		System.out.println(new Solution().minFallingPathSum(arr));
	}
}