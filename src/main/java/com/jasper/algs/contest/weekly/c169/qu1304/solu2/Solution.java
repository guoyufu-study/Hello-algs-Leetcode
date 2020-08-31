package com.jasper.algs.contest.weekly.c169.qu1304.solu2;

/**
 * 1304. 和为零的N个唯一整数
 * 
 * <p> n/2 个正数，n/2 个负数，一个零
 */
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i = 0, mid = n/2;
        for(int num=1; num<=mid; num++) {
            ans[i++] = num;
            ans[i++] = -num;
        }
        
        if(i<n) ans[i] = 0;
        return ans;
    }
}
