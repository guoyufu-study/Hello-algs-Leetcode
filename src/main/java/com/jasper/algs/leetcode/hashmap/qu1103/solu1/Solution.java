package com.jasper.algs.leetcode.hashmap.qu1103.solu1;

/**
 * 1103. 分糖果 II
 * 
 * <p>暴力求解
 */
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
    	int[] ans = new int[num_people]; 
    	
    	int count = 1;//第几次发糖果，这次要发几颗糖果
    	while(candies > 0) {
    		// 发糖果
    		ans[(count-1)%num_people] += Math.min(count, candies);
    		
    		// 更新剩余糖果数
    		candies -= count;
    		// 更新下一次要发的糖果数量
    		count++;
    	}
    	
    	return ans;
    }
}