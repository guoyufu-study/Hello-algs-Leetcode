package com.jasper.algs.leetcode.maths.qu0043.solu2;

/**
 * 优化竖式
 */
class Solution {
    public String multiply(String num1, String num2) {
    	// 边界值
    	if(num1.charAt(0) == '0' || num2.charAt(0) == '0') //其中一个乘数为0
			return "0";
    	
    	int l1 = num1.length(); // 被乘数
    	int l2 = num2.length(); // 乘数 
    	char[] ans = new char[l1+l2];
    	
    	// 逐位相乘
    	for (int i = l2-1; i >= 0; i--) {// 乘数 num2
			int multiplier = num2.charAt(i)-'0';
			if(multiplier==0) continue; // 乘数字符为0，跳过
			
			for (int j = l1-1; j >= 0; j--) {// 被乘数 num1
				int multiplicand = num1.charAt(j)-'0';
				int product = multiplicand * multiplier + ans[i+j+1];
				
				ans[i+j] += (char) (product / 10);
				ans[i+j+1] = (char) (product % 10); 
			}
			
		}
    	
    	// 数字 -> 字符
    	for (int i = ans.length-1; i >= 0; i--)
			ans[i] = (char) (ans[i]+'0');
    	
    	if(ans[0]=='0') return new String(ans, 1, ans.length-1);// 首位是0
    	return new String(ans);
    }
    
    
    public static void main(String[] args) {
		String num1 = "123";
		String num2 = "456";
		
		System.out.println(new Solution().multiply(num1, num2));
	}
}