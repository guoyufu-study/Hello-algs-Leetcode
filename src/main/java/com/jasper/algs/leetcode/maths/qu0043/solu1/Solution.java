package com.jasper.algs.leetcode.maths.qu0043.solu1;

/**
 * 普通竖式
 */
class Solution {
    public String multiply(String num1, String num2) {
    	// 边界值
    	if(num1.charAt(0) == '0' || num2.charAt(0) == '0') //其中一个乘数为0
			return "0";
    	
    	int l1 = num1.length(); // 被乘数
    	int l2 = num2.length(); // 乘数 
    	int[] ans = new int[l1+l2];
    	
    	// 逐位相乘
    	for (int i = l2-1; i >= 0; i--) {// 乘数 num2
			int multiplier = num2.charAt(i)-'0';
			if(multiplier==0) continue; // 乘数字符为0，跳过
			
			int carry = 0;
			for (int j = l1-1; j >= 0; j--) {// 被乘数 num1
				int multiplicand = num1.charAt(j)-'0';
				int product = multiplicand * multiplier + carry + ans[i+j+1];// 相加
				
				int digit = product%10;
				ans[i+j+1] = digit; 
				carry = product / 10;
			}
			
			ans[i] = carry;
		}
    	
    	// 数字 -> 字符
    	char[] answ = new char[l1+l2];
    	for (int i = ans.length-1; i >= 0; i--)
			answ[i] = (char) (ans[i]+'0');
    	
    	if(answ[0]=='0') return new String(answ, 1, answ.length-1);// 首位是0
    	return new String(answ);
    }
}