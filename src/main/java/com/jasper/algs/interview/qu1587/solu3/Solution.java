package com.jasper.algs.interview.qu1587.solu3;

/**
 * 3. 辅助字典
 * <p>空间换时间
 * <p> 一：辅助数组：计数，先存再查
 */
class Solution {
	
    public int[] missingTwo(int[] nums) {
    	int[] ans = new int[2];
    	
    	// 字典
    	int[] helper = new int[nums.length+3];
    	
    	// 先存
    	for (int i = 0; i < nums.length; i++) {
			helper[nums[i]] = nums[i];
		}
    	
    	// 再找
    	int count = 0;
    	for (int i = 1; i < helper.length; i++) {
			if(helper[i]==0) {
				ans[count++] = i;
				if(count == 2) break;
			}
		}
    	
		
    	return ans;
    }
}