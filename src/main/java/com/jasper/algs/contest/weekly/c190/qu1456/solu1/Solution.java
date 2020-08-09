package com.jasper.algs.contest.weekly.c190.qu1456.solu1;

/**
 * 1456. 定长子串中元音的最大数目
 * 
 * <p> 双指针
 */
class Solution {
    public int maxVowels(String s, int k) {
    	char[] arr = new char[] {'a', 'e', 'i', 'o', 'u'};
    	int[] hash = new int[26];
    	for (int i = 0; i < 5; i++) {
			hash[arr[i]-'a'] = 1;
		}
    	
    	int ans = 0;
    	int begin = 0, end = 0, count = 0;
    	char[] sArr = s.toCharArray();
    	for (; end < k; end++) {
    		count += hash[sArr[end]-'a'];
		}
    	ans = count;
    	
    	int len = s.length();
		for (; end < len; end++, begin++) {
    		count += hash[sArr[end]-'a'];
    		count -= hash[sArr[begin]-'a'];
			if(count==k) return k;
			ans = Math.max(count, ans);
		}
    	return ans;
    }
}