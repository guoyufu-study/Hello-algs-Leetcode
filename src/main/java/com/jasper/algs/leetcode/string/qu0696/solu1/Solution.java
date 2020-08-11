package com.jasper.algs.leetcode.string.qu0696.solu1;

/**
 * 0696. 计数二进制子串
 * 
 * <p>按字符分组
 */
class Solution {
    public int countBinarySubstrings(String s) {
    	int ptr = 0, n = s.length(), last = 0, ans = 0;
    	// 遍历字符串
    	char[] sc = s.toCharArray();
    	while(ptr<n) {
    		// 计数连续相同字符
    		char c = sc[ptr];
    		int count = 0;
    		while(ptr<n && sc[ptr]==c) {
    			++ptr;
    			++count;
    		}
    		
    		// 构造答案
    		ans += Math.min(count, last);
    		last = count;
    	}
    	
    	return ans;
    }
}