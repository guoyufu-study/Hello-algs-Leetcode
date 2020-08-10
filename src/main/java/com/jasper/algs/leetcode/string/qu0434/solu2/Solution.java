package com.jasper.algs.leetcode.string.qu0434.solu2;

/**
 * 0434. 字符串中的单词数
 * 
 * <p> 原地统计
 */
class Solution {
    public int countSegments(String s) {
    	int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}