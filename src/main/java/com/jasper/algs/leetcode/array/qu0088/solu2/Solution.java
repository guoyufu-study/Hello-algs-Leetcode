package com.jasper.algs.leetcode.array.qu0088.solu2;

import java.util.stream.IntStream;

/**
 * 0088. 合并两个有序数组
 *
 * <p>
 * 双指针 / 从前往后
 */
class Solution {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Make a copy of nums1.
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);

		// Two get pointers for nums1_copy and nums2.
		int p1 = 0;
		int p2 = 0;

		// Set pointer for nums1
		int p = 0;

		// Compare elements from nums1_copy and nums2
		// and add the smallest one into nums1.
		while ((p1 < m) && (p2 < n))
			nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

		// if there are still elements to add
		if (p1 < m)
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		if (p2 < n)
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = new int[] { 2, 5, 6 };
		int n = 3;

		new Solution().merge(nums1, m, nums2, n);

		IntStream.of(nums1).forEach(System.out::println);
	}
}