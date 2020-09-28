package com.jasper.algs.interview.qu1602.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.02. 单词频率
 * 
 * <p> 辅助字典（HashMap）
 */
class WordsFrequency {
	
	Map<String, Integer> counts;
	
    public WordsFrequency(String[] book) {
    	counts = new HashMap<String, Integer>();
    	for(String word : book)
    		counts.put(word, get(word)+1);
    }
    
    public int get(String word) {
    	
    	return counts.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */