package com.jasper.algs.leetcode.string.qu0028.solu2;

/**
 * 0028. 实现 strStr()
 * 
 * <p> 双指针
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int l = needle.length();
        if(l==0) return 0; // 边界
        
        int pn = 0;
        while(pn<n-l+1) {
        	// 在 haystack 中找到 needle 中的第一个字符
        	while(pn<n-l+1 && haystack.charAt(pn)!=needle.charAt(0))
        		++pn;
        	
        	// 计算最大匹配字符串
        	int currLen=0, pl=0;
        	while(pl<l && pn<n && haystack.charAt(pn)==needle.charAt(pl)) {
        		++pn;
        		++pl;
        		++currLen;
        	}
        	
        	// 已找到
        	if(currLen==l) return pn -l;
        	
        	// 未找到
        	pn = pn - currLen + 1;
        }
        
    	return -1;
    }
}