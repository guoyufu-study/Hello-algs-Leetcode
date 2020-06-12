package com.jasper.algs.leetcode.string.qu0014.solu;

/**
 * 0014. 最长公共前缀
 * 
 * <p> 枚举字符串的每一列
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
    	
    	
		return strs[0];
    }
    
    public static void main(String[] args) {
    	
    	String[] strs = new String[] {"flower","flow","flight"};
    	
    	System.out.println(new Solution().longestCommonPrefix(strs));
	}
}