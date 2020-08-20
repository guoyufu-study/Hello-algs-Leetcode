package com.jasper.algs.leetcode.dp.qu0152.solu1;

/**
 * 0152. 乘积最大子数组
 * 
 * <p>动态规划
 *
 */
class Solution {
    public int maxProduct(int[] nums) {
    	// 边界
    	if(nums==null || nums.length==0) 
    		throw new IllegalArgumentException("输入数组至少应包含一个参数");
    	
    	// 动态规划
    	int N = nums.length;
    	int[] max = new int[N+1];// 以num结尾的乘积最大子数组的乘积
    	max[0] = nums[0];
    	int[] min = new int[N+1];// 以num结尾的乘积最小子数组的乘积
    	min[0] = nums[0];
    	
    	int ans = max[0];
    	for (int i = 1; i < N; i++) {
			max[i] = Math.max(nums[i], Math.max(max[i-1] * nums[i], min[i-1] * nums[i]));
			min[i] = Math.min(nums[i], Math.min(max[i-1] * nums[i], min[i-1] * nums[i]));
			ans = Math.max(ans, max[i]);
		}
    	
    	return ans;
    }
}