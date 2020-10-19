package com.jasper.algs.contest.biweekly.bc35.qu1589.solu1;

import java.util.Arrays;

/**
 * 1589. 所有排列中的最大和
 * 
 * <p> 排序 + 扫描线 + 前缀和差分
 */
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        // 扫描线
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int[] req : requests) {
            freq[req[0]]++;
            freq[req[1]+1]--;
        }
        for(int i=0; i<n; i++) // 前缀和
            freq[i+1] += freq[i];
        
        Arrays.sort(freq);//排序
        Arrays.sort(nums);
        
        // 统计
        long ans = 0;
        for(int i=n-1; i>=0 && freq[i+1]>0; i--) {
            ans += (long)freq[i+1] * nums[i];
        }

        return (int)(ans%1_000_000_007);
    }
}