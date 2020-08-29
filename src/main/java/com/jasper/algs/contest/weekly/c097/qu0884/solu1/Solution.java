package com.jasper.algs.contest.weekly.c097.qu0884.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0884. 两句话中的不常见单词
 * 
 * <p> 题意实现
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
    	String[] As = A.split(" ");
    	Map<String,Integer> am = new HashMap<String, Integer>();
    	for (String s : As) {
			am.put(s, am.getOrDefault(s, 0)+1);
		}
    	String[] Bs = B.split(" ");
    	Map<String,Integer> bm = new HashMap<String, Integer>();
    	for (String s : Bs) {
    		bm.put(s, bm.getOrDefault(s, 0)+1);
    	}
    	
    	List<String> ans = new ArrayList<String>();
    	for (Map.Entry<String, Integer> kv: am.entrySet()) {
			if(kv.getValue()==1 && !bm.containsKey(kv.getKey()))
				ans.add(kv.getKey());
		}
    	for (Map.Entry<String, Integer> kv: bm.entrySet()) {
    		if(kv.getValue()==1 && !am.containsKey(kv.getKey()))
    			ans.add(kv.getKey());
    	}
    	
    	
    	return ans.toArray(new String[ans.size()]);
    }
}