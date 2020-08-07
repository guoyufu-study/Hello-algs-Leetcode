package com.jasper.algs.leetcode.string.qu0125.solu2;

/**
 * 0125. 验证回文串
 * 
 * <p>筛选 + 判断：双指针
 */
class Solution {
    public boolean isPalindrome(String s) {
    	// 筛选
    	StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        
        // 双指针 -> 判断
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
    
    public static void main(String[] args) {
		// true
//    	String s = "A man, a plan, a canal: Panama";
    	
    	// false
    	String s = "race a car";
    	
    	System.out.println(new Solution().isPalindrome(s));
	}
}