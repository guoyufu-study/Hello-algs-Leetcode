package com.jasper.algs.contest.biweekly.bc33.qu5479.solu1;

/**
 * 5479. 千位分隔数
 *
 * <p> 逆序装填
 */
class Solution {
    public String thousandSeparator(int n) {
        if(n==0) return "0";
        char[] ans = new char[14];
        int i = 1;
        while(n!=0) {
            ans[14-(i++)] = (char)('0' + n%10);
            if(i%4==0) ans[14-(i++)] = '.';
            n /= 10;
        }
        return i%4==1 ? new String(ans, 16-i, i-2) : new String(ans, 15-i, i-1);
    }
}