package com.jasper.algs.interview.qu0102.solu2;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 
 * <p>辅助字典 + 计数相消
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
    	int m = s1.length();
    	int n = s2.length();
    	if(m!=n) return false;
    	
    	char[] S1 = s1.toCharArray();
    	char[] S2 = s2.toCharArray();
    	int[] helper = new int[26];
    	for (int i = 0; i < n; i++) {
			helper[S1[i]-'a']++;
			helper[S2[i]-'a']--;
		}
    	
    	for (int i : helper) {
			if(i!=0)
				return false;
		}
    	return true;
    }
}