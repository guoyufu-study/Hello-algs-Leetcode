package com.jasper.algs.contest.weekly.c207.qu1592.solu1;

/**
 * 1592. 重新排列单词间的空格
 * 
 * <p> 遍历计数 + 快慢指针
 */
class Solution {
    public String reorderSpaces(String text) {
    	// 遍历计数
    	int n = text.length(), blanks = 0, words = 0;
    	char[] tc = text.toCharArray();
    	for (int i = 0; i < n; i++) {
			if(tc[i]==' ') blanks++;
			else if(i+1<n && tc[i+1]==' ') words++;
		}
    	if(tc[n-1]!=' ') words++;
    	
    	int len = words==1 ? 0 : blanks / (words - 1);
    	
    	// 快慢指针
    	char[] ans = new char[n];
    	int slow=0, fast=0;
    	while(slow<n || fast<n) {
    		// 略过空格
    		while(fast<n && tc[fast]==' ') fast++;
    		// 复制单词
    		while(fast<n && tc[fast]!=' ') 
    			ans[slow++] = tc[fast++];
    		// 补空格
    		int k = 0;
    		while(slow<n && (k++<len || fast==n)) 
    			ans[slow++] = ' ';
    		
    	}
    	return new String(ans);
    }
}