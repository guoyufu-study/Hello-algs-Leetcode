package com.jasper.algs.leetcode.maths.qu0009.solu3;

/**
 * 0009. 回文数
 * 
 * <p> 反转一半整数
 */
class Solution {
    public boolean isPalindrome(int x) {
        
    	// 边界值处理
    	if(x==0) return true; // 0
        if(x<0 || x%10==0) return false; // 负数、10的倍数

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
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