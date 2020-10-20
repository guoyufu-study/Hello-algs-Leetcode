package com.jasper.algs.leetcode.dp.qu0312.solu2;

import java.util.Arrays;

/**
 * 0312.戳气球
 * <p>
 * 记忆化搜索
 */
class Solution {
    public int maxCoins(int[] nums) {
    	int n = nums.length;
    	
    	// 虚拟边界
    	int[] nums2 = new int[n+2];
    	System.arraycopy(nums, 0, nums2, 1, n);
    	nums2[0] = 1;
    	nums2[n+1] = 1;
    	
    	// 辅助数组
    	int[][] memo = new int[n+2][n+2];
    	for(int[] a : memo) Arrays.fill(a, -1);
    	
    	// 戳气球
    	return maxCoins(nums2, 0, n+1, memo);
    }
    
    
    private int maxCoins(int[] nums, int s, int e, int[][] memo) {
    	// 查缓存、回归条件
    	if(memo[s][e] >= 0) return memo[s][e];
    	
    	if(s+1==e) memo[s][e] = 0;
    	else 
	    	// 分治。k为最后一个被戳破的气球
	    	for (int k = s+1; k < e; k++) 
	    		// 计算并缓存
	    		memo[s][e] = Math.max(memo[s][e], maxCoins(nums, s, k, memo)
						+ maxCoins(nums, k, e, memo)
						+ nums[s]*nums[k]*nums[e]);
    	
    	return memo[s][e];
    }
    
    public static void main(String[] args) {
		int[] nums = new int[] {3,1,5,8}; //maxCoins = 167
//		int[] nums = {3,4,5,6,7,5,7,8,5,3,2,5};//maxCoins = 1918
//		int[] nums = new int[] {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}; //maxCoins = 3630
		
        long start = System.currentTimeMillis();
        
		// 分治法用时：1969 -> 1
//        start = System.currentTimeMillis();
		System.out.println("最多能得到金币："+new Solution().maxCoins(nums));
		System.out.println("分治用时   ：   " + String.valueOf(System.currentTimeMillis() - start) /* + "  运算次数："+sum1+"  实际运算次数："+sum2 */);
	}
    
//     1  3, 1, 5,   8    1
//     length = 6 N=4
    
    
//     0  1  2  3    4    5
//    [
//    [0, 0, 3, 30, 159, 167],  0
//    [0, 0, 0, 15, 135, 159],  1
//    [0, 0, 0, 0,  40,  48],   2
//    [0, 0, 0, 0,  0,   40],   3
//    [0, 0, 0, 0,  0,   0],    4
//    [0, 0, 0, 0,  0,   0]     5
//    ]
    
//    i=3 j=5 => k=4  dp[3][4] + dp[4][5] + nums[3]*nums[4]*nums[5] => 0+0+40 => 40
//    i=2 j=4 => k=3  dp[2][4] => 40
//    i=2 j=5 => k=3  0+40+5 => 45 
//    			 k=4  40+0+8 => 48
    
//    i=1 j=3 => k=2 => 15
//    i=1 j=4 => k=2 => 0+40+24 => 64
//    			 k=3 => 15+0+120 => 135
//    i=1 j=5 
    
    
    
}