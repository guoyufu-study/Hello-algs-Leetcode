package com.jasper.algs.leetcode.string.qu0125.solu1;

/**
 * 0125. 验证回文串
 * 
 * <p>筛选 + 判断：翻转
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
        
        // 翻转
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        
        // 判断
        return sgood.toString().equals(sgood_rev.toString());
    }
    
    public static void main(String[] args) {
		// true
//    	String s = "A man, a plan, a canal: Panama";
    	
    	// false
    	String s = "race a car";
    	
    	System.out.println(new Solution().isPalindrome(s));
	}
}