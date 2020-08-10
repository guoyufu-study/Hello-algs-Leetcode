package com.jasper.algs.leetcode.string.qu0520.solu1;

/**
 * 0520. 检测大写字母
 * 
 * <p> 判断前两个字符决定大小写
 */
class Solution {
    public boolean detectCapitalUse(String word) {
    	// 边界
    	int n = word.length();
        if(n<=1)
            return true;
        
        char[] s = word.toCharArray();
        boolean big = s[0]<='Z' ? s[1]<='Z' ? true : false : false;
        for(int i=1; i<n; i++) {
            if((big && s[i] > 'Z') || (!big && s[i]<='Z'))
                return false;
        }

        return true;
    }
}