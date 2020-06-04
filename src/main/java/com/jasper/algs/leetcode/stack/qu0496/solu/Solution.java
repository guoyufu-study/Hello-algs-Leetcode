package com.jasper.algs.leetcode.stack.qu0496.solu;

import java.util.stream.IntStream;

/**
 * 0496. 下一个更大的元素 I
 * 
 * <p> 2刷
 */
class Solution {
	
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	
    	return nums1;
    }
    
    public static void main(String[] args) {
    	// -1,3,-1
//		int[] nums1 = new int[] {4,1,2};
//		int[] nums2 = new int[] {1,3,4,2};
		
		// 3,-1
//		int[] nums1 = new int[] {2,4};
//		int[] nums2 = new int[] {1,2,3,4};
		
    	// [-1,-1,-1,-1,-1]
		int[] nums1 = new int[] {1,3,5,2,4};
		int[] nums2 = new int[] {5,4,3,2,1};
		
		IntStream.of(new Solution().nextGreaterElement(nums1, nums2))
			.forEach( num -> {
				System.out.print(num + ",");
			});
	}
}