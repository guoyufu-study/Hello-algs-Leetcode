package com.jasper.algs.contest.weekly.c202.qu5185.solu1;

/**
 * 5185. 存在连续三个奇数的数组
 * 
 * <p> 滑动窗口
 */
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {

    	int n = arr.length, left = -1, right = 0;
    	if(n<2) return false;
    	
    	while(right<n) {
    		if(arr[right]%2==1) {
    			if(right-left>=3) 
    				return true;
    		} else {
    			left = right;
    		}
    		right++;
    	}
    	
    	return false;
    }
}