package com.jasper.algs.leetcode.string.qu0125.solu3;

/**
 * 0125. 验证回文串
 * 
 * <p>在原字符串上直接判断：双指针
 */
class Solution {
    public boolean isPalindrome(String s) {
    	
    	int left = 0, right = s.length()-1;
    	while(left<right) {
    		while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
    			left++;
    		}
    		while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
    			right--;
    		}
    		
    		if(left < right) {
    			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) 
                    return false;
    			left++;
        		right--;
    		}
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