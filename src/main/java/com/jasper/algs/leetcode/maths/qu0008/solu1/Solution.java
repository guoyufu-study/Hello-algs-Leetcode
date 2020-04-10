package com.jasper.algs.leetcode.maths.qu0008.solu1;

class Solution {
    public int myAtoi(String str) {
    	int ans = 0;

    	// 空白符
    	int index = 0;
		while(index < str.length() && str.charAt(index)==' ') {
			index++;
		}
		if(index == str.length()) return 0;// 全空白符，或空字符串
		
		//正负号
		boolean positive = true; 
		if(str.charAt(index)=='+') index++; 
		else if(str.charAt(index)=='-') {
			index++;
			positive = false;
		}
		
		// 边界值处理
		int limit = positive?-Integer.MAX_VALUE:Integer.MIN_VALUE;
		
		//逐个读取数字
		while(index<str.length() && 
				str.charAt(index)<='9' && str.charAt(index)>='0') { // 非数字时截断
			int digit = (str.charAt(index++)-'0');
			
			// 边界值处理
			if(ans<(limit+digit)/10){
                return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
			
			ans=ans*10-digit; //用减法
		}
    	
		return positive?-ans:ans ;
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