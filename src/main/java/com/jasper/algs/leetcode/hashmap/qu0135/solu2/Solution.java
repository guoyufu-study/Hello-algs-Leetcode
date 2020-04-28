package com.jasper.algs.leetcode.hashmap.qu0135.solu2;

import java.util.Arrays;

/**
 * 135. 分发糖果（按评分分糖果）
 * 
 * <p> 两个辅助数组
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
    	
    	// 从右到左
    	int[] r2l = new int[N];
    	Arrays.fill(r2l, 1); // 初始化，每人最少1颗
    	for (int i = N-2; i >= 0; i--) {
			if(ratings[i] > ratings[i+1])
				r2l[i] = r2l[i+1] + 1;
		}
    	
    	// 统计
    	int ans = 0;
    	for (int i = 0; i < r2l.length; i++) {
			ans += Math.max(l2r[i], r2l[i]);
		}
    	
    	return ans;
    }

	
    public static void main(String[] args) {
		int[] ratings = new int[] {1,3,2,2,1}; //7
//		int[] ratings = new int[] {1,0,2};//5
		
		System.out.println(new Solution().candy(ratings));
	}
}