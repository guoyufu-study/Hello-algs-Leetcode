package com.jasper.algs.leetcode.hashmap.qu0383.solu1;

/**
 * 0383. 赎金信
 * 
 * <p> 字典计数
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	int n = ransomNote.length(), m = magazine.length();
    	if(n > m) return false;
    	
    	int[] helper = new int[26];
    	for (char c : magazine.toCharArray()) {
			helper[c-'a']++;
		}
    	
    	for (char c : ransomNote.toCharArray()) {
			helper[c-'a']--;
		}
    	
    	for (int num : helper) {
			if(num<0) 
				return false;
		}
    	return true;
    }
}