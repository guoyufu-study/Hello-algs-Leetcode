package com.jasper.algs.leetcode.hashmap.qu0135.solu1;

import java.util.Arrays;

/**
 * 135. 分发糖果（按评分分糖果）
 * 
 * <p> 暴力求解：不满足条件，则补发糖果
 */
class Solution {
    public int candy(int[] ratings) {
    	
    	// 辅助数组：记录分配糖果数
    	int N = ratings.length;
		int[] candies = new int[N];
    	Arrays.fill(candies, 1); // 初始化，每人最少1颗
    	
    	boolean isOk = false;
    	while(!isOk) {
    		// 开局假设已成功分好糖果
    		isOk = true;
    		for (int i = 0; i < N; i++) {
    			// 评分高，但所得糖果不足，补足糖果
    			
    			// VS prev
				if(i>0 && ratings[i]>ratings[i-1] && candies[i]<=candies[i-1]) {
					candies[i] = candies[i-1] + 1;
					isOk = false;
				}
				
				// VS after
				if(i<N-1 && ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]) {
					candies[i] = candies[i+1] + 1;
					isOk = false;
				}
			}
    	}
    	
    	// 统计
    	int ans = 0;
    	for (int candy : candies) {
			ans += candy;
		}
    	return ans;
    }

	
	public static void main(String[] args) {
//		int[] ratings = new int[] {1,3,2,2,1}; //7
		int[] ratings = new int[] {1,0,2};//5
		
		System.out.println(new Solution().candy(ratings));
	}
}