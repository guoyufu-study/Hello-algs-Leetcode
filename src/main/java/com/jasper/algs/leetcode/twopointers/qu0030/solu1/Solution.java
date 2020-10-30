package com.jasper.algs.leetcode.twopointers.qu0030.solu1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0030. 串联所有单词的子串
 *
 * <p> 滑动窗口
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    	int len = s.length(), n = words.length, wl = words[0].length(), wsl = n*wl;
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	// 计数 words
    	Map<String,Integer> map = new HashMap<String, Integer>();
    	for(String word : words) map.compute(word, (k,v)->v==null?1:v+1);
    	
    	for (int i = 0; i < wl; i++) {
    		// 辅助字典
    		Map<String,Integer> tmp = new HashMap<String, Integer>();
    		// 滑动窗口
    		int left = i, right = i, count = 0;
    		while(left+wsl<=len && right+wl<=len) {
    			String word = s.substring(right, right+wl);
    			tmp.compute(word, (k,v)->v==null?1:v+1);
    			++count;
    			// 收缩窗口
    			while(tmp.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
    				tmp.compute(s.substring(left, left+wl), (k,v)->v==1?null:v-1);
    				--count;
    				left += wl;
    			}
    			
    			// 维护结果
    			if(count==n) ans.add(left);
    			
    			// 扩展窗口
    			right += wl;
    		}
		}
    	
    	Collections.sort(ans);
    	return ans;
    }
}