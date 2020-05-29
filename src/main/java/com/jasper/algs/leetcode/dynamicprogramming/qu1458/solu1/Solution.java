package com.jasper.algs.leetcode.dynamicprogramming.qu1458.solu1;

/**
 * 1458. 两个子序列的最大点积
 * 
 * <p> 二维动态规划
 */
class Solution {
	
    public int maxDotProduct(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	// 动态规划 dp(i,j) = nums1[i] * nums2[j]
    	int[][] dp = new int[m][n];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
				dp[i][j] = nums1[i] * nums2[j];
			}
		}
    	
    	// 动态规划 dp(i,j) = max(...)
    	for (int i = 1; i < m; i++) {
			dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
		}
    	for (int j = 1; j < n; j++) {
			dp[0][j] = Math.max(dp[0][j], dp[0][j-1]);
		}
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(Math.max(
						// 不选：选一个，都不选
						Math.max(dp[i-1][j], // 只选nums2[j]
								dp[i][j-1]), // 只选 nums1[i]
						
						// 都选
						dp[i][j]), // 只选 nums1[i]和nums2[j]
						dp[i-1][j-1] + dp[i][j]); // 同时选 nums1[i]和nums2[j]，并选前面的项
			}
		}
    	
    	
    	return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
    	// 18
    	int[] nums1 = new int[] {2,1,-2,5};
    	int[] nums2 = new int[] {3,0,-6};
    	
    	// 21
//    	int[] nums1 = new int[] {3,-2};
//    	int[] nums2 = new int[] {2,-6,7};
    	
    	// -1
//    	int[] nums1 = new int[] {-1,-1};
//    	int[] nums2 = new int[] {1,1};
    	
    	System.out.println(new Solution().maxDotProduct(nums1, nums2));
	}
}