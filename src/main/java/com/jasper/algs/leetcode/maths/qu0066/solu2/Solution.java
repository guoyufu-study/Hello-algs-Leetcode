package com.jasper.algs.leetcode.maths.qu0066.solu2;

/**
 * 优化解法1
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits; // 原数字不是9，结束
        }
        digits = new int[digits.length + 1]; // 原数字全是9，最高位是1，其它全是0
        digits[0] = 1;
        return digits;
    }
}