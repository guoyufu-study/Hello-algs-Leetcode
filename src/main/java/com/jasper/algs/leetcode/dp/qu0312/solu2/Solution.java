package com.jasper.algs.leetcode.dp.qu0312.solu2;

/**
 * 0312.戳气球
 * <p>
 * 分治法
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
    	
    	// 戳气球
    	int ans = maxCoins(nums2, 0, N+1, helper);
    	
    	return ans;
    }
    
    
    private int maxCoins(int[] nums, int left, int right, int[][] helper) {
    	// 回归条件
    	if(left==right-1)
    		return 0;
    	
    	// 查缓存
    	if(helper[left][right] != 0)
    		return helper[left][right];
    		
    	// 分治。k为最后一个被戳破的气球
    	int maxCoins = 0;
    	for (int k = left+1; k < right; k++) {
			int tmp = maxCoins(nums, left, k, helper)
					+ maxCoins(nums, k, right, helper)
					+ nums[left]*nums[k]*nums[right];
			
			if(tmp>maxCoins) maxCoins = tmp;
		}
    	
    	// 缓存
    	helper[left][right] = maxCoins;
    	
    	return maxCoins;
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