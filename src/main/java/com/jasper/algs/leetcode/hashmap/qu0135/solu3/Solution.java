package com.jasper.algs.leetcode.hashmap.qu0135.solu3;

import java.util.Arrays;

/**
 * 135. 分发糖果（按评分分糖果）
 * 
 * <p> 一个辅助数组（简单优化空间复杂度）
 */
class Solution {
    public int candy(int[] ratings) {
    	
    	int N = ratings.length;
    	
    	// 辅助数组：记录分配糖果数
    	
    	// 从左到右
		int[] l2r = new int[N];
    	Arrays.fill(l2r, 1); // 初始化，每人最少1颗
    	for (int i = 1; i < N; i++) {
			if(ratings[i]>ratings[i-1])
				l2r[i] = l2r[i-1] + 1;
		}
    	
    	// 统计
    	int ans = l2r[N-1];
    	int prev = 1;
    	for (int i = N-2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1])
				prev += 1;
			else prev = 1;
			ans += Math.max(l2r[i], prev);
		}
    	
    	return ans;
    }

	
    public static void main(String[] args) {
//		int[] ratings = new int[] {1,3,2,2,1}; //7
		int[] ratings = new int[] {1,0,2};//5
		
		System.out.println(new Solution().candy(ratings));
	}
}