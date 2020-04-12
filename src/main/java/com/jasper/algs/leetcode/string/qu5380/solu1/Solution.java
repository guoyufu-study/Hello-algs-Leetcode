package com.jasper.algs.leetcode.string.qu5380.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力搜索
 */
class Solution {
    public List<String> stringMatching(String[] words) {

    	List<String> ans = new ArrayList<String>();
    	
    	for (int i = 0; i < words.length; i++) { // 子串
    		for (int j = 0; j < words.length; j++) { // 长串
				if(i!=j && words[j].indexOf(words[i])>-1) {
					ans.add(words[i]);
					words[i]=""; // 避免再次使用
					break;
				}
			}
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
		System.out.println("hello hello world".indexOf("hello world"));
	}
}
