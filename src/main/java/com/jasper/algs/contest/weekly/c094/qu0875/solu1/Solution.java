package com.jasper.algs.contest.weekly.c094.qu0875.solu1;

/**
 * 0875. 爱吃香蕉的珂珂
 * 
 * <p> 二分查找
 */
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
    	// 二分查找
    	int left = 1, right = 1_000_000_000;
    	while(left < right) {
    		int mid = (left + right) / 2;
    		int tmp = 0;
    		for (int pile : piles) {
				tmp += -Math.floorDiv(-pile, mid);
			}
    		if(tmp <= H) right = mid;// 吃快了。正好吃完，也可能吃快了。
    		else left = mid + 1; // 吃慢了。
    	}
    	
    	return left;
    }
}