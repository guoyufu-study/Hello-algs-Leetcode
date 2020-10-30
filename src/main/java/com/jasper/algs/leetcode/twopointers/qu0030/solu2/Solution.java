package com.jasper.algs.leetcode.twopointers.qu0030.solu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
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
    		Map<String,List<Integer>> tmp = new HashMap<String, List<Integer>>();
    		// 滑动窗口
    		int left = i, right = i, count = 0;
    		while(left+wsl<=len && right+wl<=len) {
    			String word = s.substring(right, right+wl);
    			final int r = right;
    			tmp.compute(word, (k,v)->{
    				if(v==null) {
    					v = new LinkedList<Integer>();
    				}
    				v.add(r);
    				return v;
    			});
    			++count;
    			// 收缩窗口
    			while(tmp.get(word).size() > map.getOrDefault(word, 0)) {
    				LinkedList<Integer> list = (LinkedList<Integer>) tmp.get(word);
    				int l = list.removeFirst();
    				if(left<=l) {
    					count-=(l-left)/wl+1;
        				left = l + wl;
    				}
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
    
    public static void main(String[] args) {
    	// [8]
    	String s = "wordgoodgoodgoodbestword";
    	String[] words = new String[] {"word","good","best","good"};
    	
    	// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//    	String s = "aaaaaaaaaaaaaa";
//    	String[] words = new String[] {"aa","aa"};
    	System.out.println(new Solution().findSubstring(s, words));
	}
}