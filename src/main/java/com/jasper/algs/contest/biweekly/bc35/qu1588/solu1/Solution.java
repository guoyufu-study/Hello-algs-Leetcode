package com.jasper.algs.contest.biweekly.bc35.qu1588.solu1;

/**
 * 1588. 所有奇数长度子数组的和
 * 
 * <p> 暴力枚举子数组 + 顺序求和
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        // 暴力枚举子数组
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j+=2) {
                for(int k=i; k<=j; k++) {
                	ans += arr[k];
                }
            }
        }

        return ans;
    }
}