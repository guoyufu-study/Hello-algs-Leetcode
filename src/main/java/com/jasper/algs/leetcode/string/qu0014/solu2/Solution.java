package com.jasper.algs.leetcode.string.qu0014.solu2;

/**
 * 0014. 最长公共前缀
 * 
 * <p>
 *
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
    	// 边界值
    	if(strs.length==0) return "";
    	if(strs.length==1) return strs[0];
    	
    	//最短字符串长度，避免越界
    	int len = Integer.MAX_VALUE;
    	for (int i = 0; i < strs.length; i++) {
			len = Math.min(strs[i].length(), len);
		}
    	
    	// 最长公共前缀索引
    	int i = 0;
    	begin :
    	for (; i < len; i++) {
    		char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i)!=c) 
					break begin;
			}
		}
    	
		return strs[0].substring(0, i);
    }
    
    public static void main(String[] args) {
    	
    	String[] strs = new String[] {"flower","flow","flight"};
    	
    	System.out.println(new Solution().longestCommonPrefix(strs));
	}
}