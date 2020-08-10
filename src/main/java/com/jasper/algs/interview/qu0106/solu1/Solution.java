package com.jasper.algs.interview.qu0106.solu1;

/**
 * 面试题 01.06. 字符串压缩
 * 
 * <p> 简单计数
 */
class Solution {
    public String compressString(String S) {
    	
    	int n = S.length();
    	
    	// 边界
    	if(n<=1)
    		return S;
    	
    	// 压缩
    	StringBuilder ans = new StringBuilder();
    	char[] sc = S.toCharArray();
    	char prev = sc[0];
    	int count = 1;
    	for (int i = 1; i < n; i++) {
			if(prev==sc[i]) {
				count++;
			} else {
				ans.append(prev).append(count);
				prev = sc[i];
				count = 1;
			}
		}
    	ans.append(prev).append(count);
    	
    	return ans.length()<n ? ans.toString() : S;
    }
}