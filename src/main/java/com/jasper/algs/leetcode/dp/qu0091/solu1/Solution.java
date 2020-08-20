package com.jasper.algs.leetcode.dp.qu0091.solu1;

/**
 * 0091. 解码方法
 * 
 * <p> 动态规划
 */
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();

        if(sc[0]=='0') return 0;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int j = i-1;
            if(sc[j]=='0') {
                if(sc[j-1] != '1' && sc[j-1] != '2') return 0;
                dp[i] = dp[i-2];
            }
            else if(sc[j-1]=='1' || (sc[j-1]=='2' && sc[j] <= '6'))
                dp[i] = dp[i-1] + dp[i-2];
            else {
                dp[i] = dp[i-1];
            }
        }

        return dp[n];
    }
}