package com.jasper.algs.contest.weekly.c190.qu1455.solu1;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * 
 * <p> 直接比较
 */
class Solution {

	public int isPrefixOfWord(String sentence, String searchWord) {

		String[] words = sentence.split(" ");
        int length = searchWord.length();
        for (int i = 0; i < words.length; i++) {
			if(words[i].length()<length) continue;
			int j = 0;
			for (; j < length; j++) {
				if(words[i].charAt(j)!=searchWord.charAt(j))
					break ;
			}
			if(j==length) return i+1;
		}
        return -1;
    }
}
