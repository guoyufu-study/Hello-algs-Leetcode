package com.jasper.algs.leetcode.twopointers.qu0042.solu4;

/**
 * 0042. 接雨水
 * 
 * <p>双指针
 * <p>记录最新左右挡板、计算紧临较矮档板的柱子的接水量
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
				ans += leftMax - heights[left];//接雨水
				left++;//左指针
				leftMax = Math.max(leftMax, heights[left]);// 左挡板
			}
			else {
				ans +=  rightMax - heights[right] ;//接雨水
				right--;//右指针
				rightMax = Math.max(rightMax, heights[right]);//右挡板
			}
			
		}
		
		return ans;
    }
}
