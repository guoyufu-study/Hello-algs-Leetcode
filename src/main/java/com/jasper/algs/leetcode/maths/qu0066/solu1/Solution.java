package com.jasper.algs.leetcode.maths.qu0066.solu1;

/**
 * 模拟相数相加（暴力）
 */
class Solution {
    public int[] plusOne(int[] digits) {
    	
    	int length = digits.length;
    	int carry = 1;// 进位
		for (int i = length-1; i >= 0; i--) {
			int sum = digits[i]+carry;
			
			digits[i] = sum%10;//数字
			carry = sum/10;//进位
		}

		// 最高位有进位
    	if(carry > 0) {
    		int[] ans = new int[length+1];
    		ans[0] = carry;
    		for (int i = 0; i < digits.length; i++) {
    			ans[i+1] = digits[i];
    		}
    		return ans;
    	}
    		
    	// 最高位没有进位
		return digits;
    }
}