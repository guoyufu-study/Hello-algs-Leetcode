package com.jasper.algs.leetcode.string.qu0541.solu1;

/**
 * 0541. 反转字符串 II
 * 
 * <p> 暴力
 */
class Solution {
    public String reverseStr(String s, int k) {
        if(k==1) return s;
        int n = s.length();
        char[] sc = s.toCharArray();
        for(int i=0; i<n; i+=2*k) {
            int left = i, right = Math.min(i+k-1, n-1);
            while(left<right) {
                char c = sc[left];
                sc[left] = sc[right];
                sc[right] = c;
                left++;
                right--;
            }
        }

        return new String(sc);
    }
}
