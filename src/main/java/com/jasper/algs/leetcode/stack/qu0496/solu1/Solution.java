package com.jasper.algs.leetcode.stack.qu0496.solu1;

/**
 * 0496. 下一个更大的元素 I
 * 
 * <p> 暴力求解
 */
class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	
    	boolean getBigger = false;//开关：false，找x；true，找比x大的值。
    	for (int i = 0; i < nums1.length; i++) {
    		int j = 0;
			for (; j < nums2.length; j++) {//找到大值
				if(getBigger) {//再找到比x大的，最近的值
					if(nums1[i]>=nums2[j]) continue;
					nums1[i] = nums2[j];
					break;
				} else if(nums1[i]==nums2[j]){ //先找到x
					getBigger = true;
				}
			}
			if(j==nums2.length) nums1[i] = -1;
			getBigger = false;
		}
    	
    	return nums1;
    }
}