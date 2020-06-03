package com.jasper.algs.leetcode.sorting.qu0179.solu1;

import java.util.Arrays;

/**
 * 0179. 最大数
 *
 * <p> 排序
 */
class Solution {
    public String largestNumber(int[] nums) {

    	String[] asStrs = new String[nums.length];
    	for (int i = 0; i < asStrs.length; i++) {
			asStrs[i] = String.valueOf(nums[i]);
		}
    	
    	Arrays.sort(asStrs, (a,b)->{
    		return (b+a).compareTo(a+b);
    	});
    	
    	// 特判：全是0
    	if (asStrs[0].equals("0")) {
            return "0";
        }
    	
    	StringBuilder ans = new StringBuilder();
    	for (String numAsStr : asStrs) {
			ans.append(numAsStr);
		}
    	
    	return ans.toString();
    }
    
    public static void main(String[] args) {
    	// 210
//    	int[] nums = new int[] {10, 2};
    	
    	// 201
//    	int[] nums = new int[] {20, 1};
    	
    	// 0  特判
//    	int[] nums = new int[] {0, 0};
    	
    	// 996962
//    	int[] nums = new int[] {962, 96, 9};
    	
    	// 162161 不是 161621
    	int[] nums = new int[] {162, 16, 1};
    	
    	System.out.println(new Solution().largestNumber(nums));
    	
    	
	}
}