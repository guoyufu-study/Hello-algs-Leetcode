package com.jasper.algs.interview.qu0105.solu1;

/**
 * 面试题 01.05. 一次编辑
 * 
 * <p> 分组讨论
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
    	
    	// 确保 m<=n
        int m = first.length();
        int n = second.length();
        if(m>n) {
        	String tmp = first;
        	first = second;
        	second = tmp;
        	m = first.length();
        	n = second.length();
        }
        
        // 多次编辑
        if(n-m>1) 
        	return false;
        
        char[] sc1 = first.toCharArray();
        char[] sc2 = second.toCharArray();
        
        // 一次替换，或者不操作
        boolean hasEdited = false;
        if(n==m) {
        	for (int i = 0; i < m; i++) {
				if(sc1[i]!=sc2[i]) {
					if(hasEdited) 
						return false;
					hasEdited = true;
				}
			}
        	return true;
        }
        
        // 添加操作
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
        	if(sc1[i]!=sc2[j]) {
				if(hasEdited) 
					return false;
				hasEdited = true;
				i--;
			}
		}
        return true;
    }
}