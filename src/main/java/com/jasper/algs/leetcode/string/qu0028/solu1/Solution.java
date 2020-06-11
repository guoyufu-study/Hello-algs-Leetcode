package com.jasper.algs.leetcode.string.qu0028.solu1;

/**
 * 0028. 实现 strStr()
 * 
 * <p> 子串逐一比较
 */
class Solution {
    public int strStr(String haystack, String needle) {
        
    	int n = haystack.length();
    	int l = needle.length();
    	
    	for (int start = 0; start < n-l+1; start++) {
			if(haystack.substring(start, start+l).equals(needle))
				return start;
		}
    	
    	return -1;
    }
}