package com.jasper.algs.leetcode.maths.qu0415.solu1;

/**
 * 0415. 两大数相加（字符串）
 * 
 * <p> 简单相加
 */
class Solution {
    public String addStrings(String num1, String num2) {
    	int len1 = num1.length();
    	int len2 = num2.length();
    	
    	int maxNum = Math.max(len1, len2)+1;
		char[] ans = new char[maxNum];
    	
		int carry = 0; //跟踪进位
    	int i = 1;
    	while(i <= maxNum) {
    		// 计算
    		int x = i<=len1? num1.charAt(len1-i)-'0':0;
    		int y = i<=len2? num2.charAt(len2-i)-'0':0;
    		int sum = carry + x + y;
    		
    		// 更新
    		ans[maxNum-i] = (char) ('0'+sum%10);
    		carry = sum/10;
    		i++;
    	}
    	if(ans[0]=='0')
    		return new String(ans, 1, maxNum-1);
    	return new String(ans);
    }
}
