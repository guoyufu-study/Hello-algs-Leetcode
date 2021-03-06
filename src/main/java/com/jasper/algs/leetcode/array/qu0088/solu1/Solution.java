package com.jasper.algs.leetcode.array.qu0088.solu1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 0088. 合并两个有序数组
 *
 * <p> 合并排序
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    	System.arraycopy(nums2, 0, nums1, m, n);
    	
    	Arrays.sort(nums1);
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