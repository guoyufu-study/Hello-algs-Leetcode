package com.jasper.algs.leetcode.string.qu0005.solu2;

/**
 * 0005. 最长回文子串
 * 
 * <p> 暴力枚举
 */
public class Solution {

	public String longestPalindrome(String s) {
		
		// 边界
		if(s==null || s.length()<=1)
			return s;
		
		int len = s.length(), maxLen = 1, begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();
        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + maxLen; j < len; j++) {
                if (validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left++] != charArray[right--]) 
                return false;
        }
        return true;
    }

}
