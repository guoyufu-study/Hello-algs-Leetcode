package com.jasper.algs.leetcode.dp.qu0312.solu3;

/**
 * 0312.戳气球
 * <p>
 * 动态规划
 */
class Solution {
    public int maxCoins(int[] nums) {
    	int N = nums.length;
    	// 边界
		if(N==0)
    		return 0;
    	
    	// 虚拟边界
    	int[] nums2 = new int[N+2];
    	System.arraycopy(nums, 0, nums2, 1, N);
    	nums2[0] = 1;
    	nums2[N+1] = 1;
    	
    	// 辅助数组
    	int[][] helper = new int[N+2][N+2];
    	
    	for (int i = N-1; i >= 0; i--) {
			for (int j = i+2; j < N+2; j++) {
				int max = 0;
				for (int k = i+1; k < j; k++) {
					int tmp = helper[i][k]+helper[k][j]+nums2[i]*nums2[k]*nums2[j];
					if(tmp>max) max = tmp;
				}
				helper[i][j] = max;
			}
		}
    	
    	return helper[0][N+1];
    }
}