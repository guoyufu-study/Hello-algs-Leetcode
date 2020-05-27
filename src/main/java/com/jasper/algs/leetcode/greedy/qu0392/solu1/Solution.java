package com.jasper.algs.leetcode.greedy.qu0392.solu1;

/**
 * 0392. 判断子序列
 * 
 * <p> 同步迭代
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
    	int n = t.length(); // 长串
    	
    	int j=0;
    	for (char c : s.toCharArray()) {
    		while(j<n && c!=t.charAt(j)) j++;
    		j++;
		}
			
    	return j<=n ? true : false;
    }
    
    public static void main(String[] args) {
    	// false
//		String s = "aaaaaa";
//		String t = "bbaaaa";
		
		// true
//		String s = "abc";
//		String t = "ahbgdc";
    	
		// true
		String s = "abcd";
		String t = "abcd";
		
		System.out.println(new Solution().isSubsequence(s, t));
	}
}