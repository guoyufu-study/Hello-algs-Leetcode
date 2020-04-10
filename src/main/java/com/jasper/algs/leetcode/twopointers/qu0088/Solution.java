package com.jasper.algs.leetcode.twopointers.qu0088;

/**
 * 双指针：从后往前
 */
class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		while(m!=0 && n !=0) {
			nums1[m+n-1] = nums1[m-1]>nums2[n-1] ? nums1[--m] : nums2[--n];
		}
		
		if(m==0) 
			while(n!=0) nums1[n-1] = nums2[--n];
		else if(n==0)
			while(m!=0) nums1[m-1] = nums1[--m];
    }
}
