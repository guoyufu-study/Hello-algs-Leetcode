package com.jasper.algs.leetcode.stack.qu0042.solu4;

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
			// 确定当前最高水位（左右挡板中最小值）
			int waterLine = Math.min(leftMax, rightMax);
			
			// 更新指针 -> 接雨水
			if(leftMax<=rightMax) {
				left++;	
				ans += waterLine > heights[left] ?waterLine - heights[left] : 0;
			}
			else {
				right--;
				ans +=  waterLine > heights[right] ?waterLine - heights[right] : 0;
			}
			
			// 更新挡板
			leftMax = Math.max(leftMax, heights[left]);
			rightMax = Math.max(rightMax, heights[right]);
		}
		
		return ans;
    }
}
