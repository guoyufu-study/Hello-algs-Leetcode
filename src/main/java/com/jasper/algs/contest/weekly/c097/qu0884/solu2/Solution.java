package com.jasper.algs.contest.weekly.c097.qu0884.solu2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0884. 两句话中的不常见单词
 * 
 * <p> 整体考虑实现
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
    	Map<String,Integer> helper = new HashMap<String, Integer>();
    	for (String s : A.split(" ")) {
			helper.put(s, helper.getOrDefault(s, 0)+1);
		}
    	for (String s : B.split(" ")) {
    		helper.put(s, helper.getOrDefault(s, 0)+1);
    	}
    	
    	List<String> ans = new ArrayList<String>();
    	for (Map.Entry<String, Integer> kv: helper.entrySet()) {
			if(kv.getValue()==1)
				ans.add(kv.getKey());
		}
    	
    	return ans.toArray(new String[ans.size()]);
    }
}