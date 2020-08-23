package com.jasper.algs.leetcode.greedy.qu0680.solu2;

/**
 * 0680. 验证回文字符串 Ⅱ
 * 
 * <p> 贪心算法
 */
class Solution {
	public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while(low<high && s.charAt(low)==s.charAt(high)) {
        	low++;
        	high--;
        }
        
        return validPalindrome(s, low+1, high) || validPalindrome(s, low, high-1);
    }

	private boolean validPalindrome(String s, int low, int high) {
		while(low < high && s.charAt(low)==s.charAt(high)) {
			low++;
			high--;
		}
		return low>=high;
	}

}