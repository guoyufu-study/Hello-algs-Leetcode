package com.jasper.algs.leetcode.twopointers.qu0042.solu4;

/**
 * 双指针
 */
class Solution {

	public int trap(int[] heights) {
		if(heights.length<=2) return 0;
		
		int ans = 0;// 结果
		int left = 0, right=heights.length-1;//左右指针
		int leftMax=heights[left], rightMax = heights[right];//左右挡板
		
		while(left<right) {
			// 确定当前最高水位 -> 接雨水 -> 更新指针 -> 更新挡板
			if(leftMax<=rightMax) {
				ans += leftMax - heights[left++];
				leftMax = Math.max(leftMax, heights[left]);
			}
			else {
				ans +=  rightMax - heights[right--] ;
				rightMax = Math.max(rightMax, heights[right]);
			}
			
		}
		
		return ans;
    }
}
