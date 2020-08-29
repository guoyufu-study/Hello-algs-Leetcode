package com.jasper.algs.leetcode.string.qu0557.solu1;

/**
 * 0557. 反转字符串中的单词 III
 * 
 * <p> 伪原地反转
 */
class Solution {
    public String reverseWords(String s) {
    	int n = s.length();
        char[] sc = s.toCharArray();
        int l=0, r=0;
        for(; r<n; r++) {
            if(sc[r]==' ') {
                reverse(sc, l, r-1);
                l = r+1;
            }
        }
        reverse(sc, l, r-1);
        return new String(sc);
    }

    void reverse(char[] sc, int left, int right) {
        while(left<right) {
            char c = sc[left];
            sc[left] = sc[right];
            sc[right] = c;
            left++;
            right--;
        }
    }
}