package com.jasper.algs.leetcode.maths.qu0066.solu2;

/**
 * 0066.大数加一
 * 
 * <p>数学特性优化
 */
class Solution {
    public int[] plusOne(int[] digits) {
    	
    	int length = digits.length;
    	
    	// 数组元素不全是9
		for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits; // 原数字不是9，结束
        }
        
        // 数组元素全是9
        digits = new int[length + 1]; // 原数字全是9，最高位是1，其它全是0
        digits[0] = 1;
        return digits;
    }
}