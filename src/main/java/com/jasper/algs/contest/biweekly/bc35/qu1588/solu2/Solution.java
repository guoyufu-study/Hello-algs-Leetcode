package com.jasper.algs.contest.biweekly.bc35.qu1588.solu2;

/**
 * 1588. 所有奇数长度子数组的和
 * 
 * <p> 暴力枚举子数组 + 前缀和差分
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        // 前缀和
        int[] prefixSum = new int[n+1];
        for(int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        
        // 暴力枚举子数组
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j+=2) {
                ans += prefixSum[j+1] - prefixSum[i];
            }
        }

        return ans;
    }
}