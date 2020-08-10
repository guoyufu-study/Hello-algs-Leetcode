package com.jasper.algs.interview.qu0109.solu1;

/**
 * 面试题 01.09. 字符串轮转
 * 
 * <p> 倍乘字符串
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length()==s2.length() && (s1+s1).indexOf(s2)!=-1;
    }
}