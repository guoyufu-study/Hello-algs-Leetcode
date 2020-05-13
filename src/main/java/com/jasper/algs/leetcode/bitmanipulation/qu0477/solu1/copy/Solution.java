package com.jasper.algs.leetcode.bitmanipulation.qu0477.solu1.copy;

/**
 * 0477. 汉明距离总和
 *
 * <p>独立计算每一位的汉明距离和
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
    	// 边界处理
    	if(nums==null || nums.length==0)
    		return 0;
    	
    	// 统计1的个数
    	int[] cnt = new int[31];
    	for (int num : nums) {
    		int i = 0;
    		while(num>0) {
    			cnt[i++] += (num & 0b1);
    			num >>= 1;
    		}
		}
    	
    	// 计算总和
    	int ans = 0;
    	int n = nums.length;
    	for (int i : cnt) {
			ans += i * (n - i);
		}
    	return ans;
    }
}