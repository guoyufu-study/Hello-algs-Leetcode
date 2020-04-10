package com.jasper.algs.leetcode.maths.qu0009.solu1;

class Solution {
    public boolean isPalindrome(int x) {
    	// 边界值处理
    	if(x==0) return true; // 0
        if(x<0 || x%10==0) return false; // 负数、10的倍数
        
        int y = x, ans=0;
        while(y!=0) {	// 不必考虑溢出情况：如果溢出一定不是回文
        	ans = ans*10 + y%10;
        	y /= 10;
        }
        
        return ans==x;
    }
    
    public static void main(String[] args) {
		int x = 0;
//		int x = 10;
//		int x = -121;
//		int x = 121;
		
		boolean palindrome = new Solution().isPalindrome(x);
		System.out.println(palindrome);
	}
}