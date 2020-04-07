package com.jasper.algs.leetcode.twopointers.qu0011.solu2;

/**
 * 双指针
 * <p>
 * 面积=长度*宽度；
 * 
 * <p>
 * 先取最大长度，然后逐渐缩小长度，尝试增加宽度；并更新最大面积
 */
class Solution {

	public int maxArea(int[] height) {
		int length = height.length;
		if(length<=1) return 0;
		
		int left=0, right=length-1;// 左右指针
		int leftMax=height[left], rightMax=height[right];//左右最大值
		int ans = (right-left)*Math.min(leftMax, rightMax);// 答案
		
		while(left<right) {
			ans = Math.max(ans, (right-left) * Math.min(leftMax, rightMax));//更新面积
			if(leftMax <= rightMax) {
				while(leftMax>=height[left] && left<right) left++;//更新左指针（新宽度小时，忽略）
				leftMax = height[left];//更新左侧最大值
			} else {
				while(rightMax>=height[right] && left<right) right--;//更新右指针（新宽度小时，忽略）
				rightMax = height[right];//更新右侧最大值
			}
		}
		
		return ans;
	}
}
