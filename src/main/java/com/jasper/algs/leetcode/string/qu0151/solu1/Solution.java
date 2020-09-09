package com.jasper.algs.leetcode.string.qu0151.solu1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 0151. 翻转字符串里的单词
 * 
 * <p> 内置API - 分割 + 倒序
 */
class Solution {
    public String reverseWords(String s) {
    	List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
    	Collections.reverse(wordList);
    	return String.join(" ", wordList);
    }
}