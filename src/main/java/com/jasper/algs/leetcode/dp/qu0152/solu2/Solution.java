package com.jasper.algs.leetcode.dp.qu0152.solu2;

/**
 * 0152. 乘积最大子数组
 * 
 * <p>动态规划：状态压缩优化
 *
 */
class Solution {
    public int maxProduct(int[] nums) {
    	// 边界
    	if(nums==null || nums.length==0) 
    		throw new IllegalArgumentException("输入数组至少应包含一个参数");
    	
    	// 动态规划
    	int max = 1;// 以num结尾的乘积最大子数组的乘积
    	int min = 1;// 以num结尾的乘积最小子数组的乘积
    	int ans = Integer.MIN_VALUE;
    	for (int num : nums) {
    		int tmp = max;
			max = Math.max(num, Math.max(max * num, min * num));
			min = Math.min(num, Math.min(tmp * num, min * num));
			ans = Math.max(ans, max);
		}
    	
    	return ans;
    }
}