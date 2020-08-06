package com.jasper.algs.leetcode.array.qu0004.solu;

/**
 * 0004.寻找两个有序数组的中位数
 * 
 * <p>5刷
 */
public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length, n = nums2.length;
		
		// 计算中位数
		int maxLeft = 0;
		
		if((m+n)%2==1) return maxLeft;
		
		int minRight = 0;
		
		return (minRight-maxLeft)/2.0 + maxLeft;
				
	}
	
	public static void main(String[] args) {
		// 2.0
//		int[] nums1 = new int[] {1,3};
//		int[] nums2 = new int[] {2};
		
		// 2.5
		int[] nums1 = new int[] {1,2};
		int[] nums2 = new int[] {3,4};
		
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
	}
}
