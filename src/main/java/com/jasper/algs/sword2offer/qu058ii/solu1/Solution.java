package com.jasper.algs.sword2offer.qu058ii.solu1;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 
 * <p> 字符串切片
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
    	return s.substring(n) + s.substring(0, n);
    }
}