package com.jasper.algs.contest.weekly.c210.qu1616.solu1;

/**
 * 1616. 分割两个字符串得到回文串
 * 
 * <p> 贪心算法
 */
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        char[] sa = a.toCharArray();
        char[] sb = b.toCharArray();
        return check(sa, sb) || check(sb, sa);
    }

    boolean check(char[] a, char[] b) {
        // 贪心
        int left = 0, n = a.length, mid = (n-1)/2;
        while(left <= mid) { // 左右相同
            if(a[left]!=b[n-1-left]) break;
            left++;
        }

        return left>mid 
        		|| isPalindrome(a, left, n-1-left) || isPalindrome(b, left, n-1-left); // 中间是回文
    }

    boolean isPalindrome(char[] s, int left, int right) {
        while(left < right) {
            if(s[left++]!=s[right--]) return false;
        }
        return true;
    }
}