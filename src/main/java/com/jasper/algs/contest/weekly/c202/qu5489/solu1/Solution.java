package com.jasper.algs.contest.weekly.c202.qu5489.solu1;

import java.util.Arrays;

/**
 * 5489. 两球之间的磁力
 * 
 * <p> 二分查找
 */
class Solution {
    public int maxDistance(int[] position, int m) {

    	Arrays.sort(position);
    	
    	int n = position.length, right = (position[n-1] - position[0])/(m-1);
    	if(m==2) return right;
    	int left = right;
    	for (int i = 1; i < n; i++) {
			left = Math.min(left, position[i]-position[i-1]);
		}
//    	if(m==n) return left;
    	
    	while(left <= right) { // 二分查找
    		int mid = (left + right)/2;
    		int count = 0, lt = 0, gt = 0; // 滑动窗口
    		while (gt < n) {
				if(position[gt]-position[lt]>=mid) {
					count++;
					lt = gt;
				}
				gt++;
			}
    		
    		if(count>=m-1) left = mid + 1;
    		else right = mid - 1;
    	}
    	return left - 1;
    }
}