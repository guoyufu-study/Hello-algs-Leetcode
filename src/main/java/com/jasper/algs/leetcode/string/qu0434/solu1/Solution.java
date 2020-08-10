package com.jasper.algs.leetcode.string.qu0434.solu1;

/**
 * 0434. 字符串中的单词数
 * 
 * <p> 内置函数
 */
class Solution {
    public int countSegments(String s) {
    	String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}