package com.jasper.algs.leetcode.interval.qu0605.solu1;

/**
 * 0605. 种花问题
 *
 * <p> 贪心算法：能种直接种
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

    	int N = flowerbed.length;
    	
    	// 边界
    	if((N+1)/2 < n) return false;
    	if(n==0) return true;//[1,0,1,0,1,0,1] 0
    	
    	// 种花
    	int count = 0;
    	for (int i = 0; i < N; i++) {
    		// 边界问题 [1,0,0,0,1,0,0] 2
			if((i==0 || flowerbed[i-1]==0) // 左
					&& flowerbed[i]==0  // 当前
					&& (i==N-1 || flowerbed[i+1]==0)) {// 右
				count++;
				if(count>=n) return true;
				flowerbed[i++] = 1;
			}
		}
    	
    	return false;
    }
}