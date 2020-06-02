package com.jasper.algs.leetcode.array.qu0088.solu3;

import java.util.stream.IntStream;

/**
 * 0088. 合并两个有序数组
 *
 * <p> 双指针 / 从后往前
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    	int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        
        while ((p1 >= 0) && (p2 >= 0))
        	nums1[p--] = (nums1[p1] >= nums2[p2]) ? nums1[p1--] : nums2[p2--];
        	
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
    
    public static void main(String[] args) {
    	int[] nums1 = new int[] {1,2,3,0,0,0};
    	int m = 3;
    	int[] nums2 = new int[] {2,5,6};
    	int n = 3;
    	
    	new Solution().merge(nums1, m, nums2, n);
    	
    	IntStream.of(nums1).forEach(System.out::println);
	}
}