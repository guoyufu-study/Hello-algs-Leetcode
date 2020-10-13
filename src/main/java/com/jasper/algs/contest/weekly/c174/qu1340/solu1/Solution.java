package com.jasper.algs.contest.weekly.c174.qu1340.solu1;

/**
 * 1340. 跳跃游戏 V
 * 
 * <p> 记忆化搜索
 */
class Solution {
    int n, d;
    int[] arr, dp;
    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        n = arr.length;
        dp = new int[n];

        int ans = 0;
        for(int i=0; i<n; i++) {
            if(dp[i]==0) {
                dp[i] = dfs(i);
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    int dfs(int start) {
        if(dp[start]!=0) return dp[start];

        // 不跳
        dp[start] = 1; 

        // 左跳
        int left = Math.max(0, start - d);
        for(int i=start-1; i>=left; i--) {
            if(arr[i]>=arr[start]) break;
            dp[start] = Math.max(dp[start], dfs(i) + 1);
        }

        // 右跳
        int right = Math.min(n-1, start + d);
        for(int i=start+1; i<=right; i++) {
            if(arr[i]>=arr[start]) break;
            dp[start] = Math.max(dp[start], dfs(i) + 1);
        }

        return dp[start];
    }
}