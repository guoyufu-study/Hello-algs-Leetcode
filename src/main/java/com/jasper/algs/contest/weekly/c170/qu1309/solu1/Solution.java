package com.jasper.algs.contest.weekly.c170.qu1309.solu1;

/**
 * 1309. 解码字母到整数映射
 * 
 * <p> 遍历
 */
class Solution {
    public String freqAlphabets(String s) {
    	int n = s.length();
    	char[] sc = s.toCharArray();
    	StringBuilder ans = new StringBuilder();
    	for (int i = 0; i < n; i++) {
			if(i+2<n && sc[i+2]=='#') {
				char c = (char) ((sc[i]-'0')*10 + (sc[i+1]-'1') + 'a');
				ans.append(c);
				i += 2;
			} else {
				char c = (char) ((sc[i]-'1') + 'a');
				ans.append(c);
			}
		}
    	return ans.toString();
    }
}
