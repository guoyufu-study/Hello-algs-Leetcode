package com.jasper.algs.contest.weekly.c189.qu1451.solu1;

import java.util.Arrays;

/**
 * 1451. 重新排列句子中的单词
 * 
 * <p> 稳定排序
 */
class Solution {
	private static final int size = 'a' -'A';
    public String arrangeWords(String text) {
    	String[] tmp = text.split(" ");
    	tmp[0] = tmp[0].toLowerCase();
    	Arrays.sort(tmp, (a,b) -> a.length() - b.length()); // 稳定排序
    	tmp[0] = (char)(tmp[0].charAt(0) - size) + tmp[0].substring(1);
    	
    	return String.join(" ", tmp);
    }
}