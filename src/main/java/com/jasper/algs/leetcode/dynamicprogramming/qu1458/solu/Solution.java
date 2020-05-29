package com.jasper.algs.leetcode.dynamicprogramming.qu1458.solu;

/**
 * 1458. 两个子序列的最大点积
 * 
 * <p> 3 刷
 */
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {

    	return 0;
    }
    
    public static void main(String[] args) {
    	// 18
    	int[] nums1 = new int[] {2,1,-2,5};
    	int[] nums2 = new int[] {3,0,-6};
    	
    	// 21
//    	int[] nums1 = new int[] {3,-2};
//    	int[] nums2 = new int[] {2,-6,7};
    	
    	// -1
//    	int[] nums1 = new int[] {-1,-1};
//    	int[] nums2 = new int[] {1,1};
    	
    	System.out.println(new Solution().maxDotProduct(nums1, nums2));
	}
}