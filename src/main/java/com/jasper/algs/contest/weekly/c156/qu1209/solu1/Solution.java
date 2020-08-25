package com.jasper.algs.contest.weekly.c156.qu1209.solu1;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * 
 * <p> 暴力求解
 */
class Solution {
    public String removeDuplicates(String s, int k) {
    	StringBuilder sb = new StringBuilder(s);
    	int len = -1;
    	while(len != sb.length()) {
    		len = sb.length();
    		for (int i = 0, count=1; i < len; i++) {
				if(i==0 || sb.charAt(i)!=sb.charAt(i-1)) {
					count = 1;
				} else if(++count == k) {
					sb.delete(i-k+1, i+1);
					break;
				}
			}
    	}
    	
    	return sb.toString();
    }
    
}