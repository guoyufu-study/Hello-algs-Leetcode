package com.jasper.algs.leetcode.string.qu0008.solu;

/**
 * 0008. 字符串转换整数 (atoi)
 * 
 * <p> 刷题
 */
class Solution {
    public int myAtoi(String str) {
    	int ans = 0;

    	
		return ans ;
    }

    public static void main(String[] args) {
    	
//		String str = "42";
		
		// 空格开头
//		String str = "   42";
		
		// 正负号开头
//		String str = "+42";
//		String str = "-42";
		
		// 空格+正负号
		String str = "   -42";
		
		// 字符串开头
//		String str = "words and 987";
		
		// 数字开头
//		String str = "4193 with words";
		
    	// 边界值处理
//		String str = "2147483648";
//		String str = "2147483647";
//    	String str = "2147483646";
		
//		String str = "-2147483649";
//		String str = "-2147483648";
//		String str = "-2147483647";
//		String str = "-91283472332";
		

		

		
		
		
		int atoi = new Solution().myAtoi(str );
		System.out.println(atoi);
	}
}