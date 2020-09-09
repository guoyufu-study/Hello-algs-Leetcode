package com.jasper.algs.sword2offer.qu058ii.solu3;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 
 * <p> 三次翻转
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] sc = s.toCharArray();
        reverseLeftWords(sc, 0, n-1);
        reverseLeftWords(sc, n, len-1);
        reverseLeftWords(sc, 0, len-1);
        return new String(sc);
    }

    void reverseLeftWords(char[] sc, int left, int right) {
        while(left < right) {
            char tmp = sc[left];
            sc[left++] = sc[right];
            sc[right--] = tmp;
        }
    }
}