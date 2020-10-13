package com.jasper.algs.leetcode.dp.qu0300.solu2;

/**
 * 0300. 最长上升子序列
 * 
 * <p> 贪心算法 + 二分查找
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 动态规划 + 二分查找
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int num : nums) {
            int left = 0, right = ans;
            while(left < right) {
                int pivot = (left + right)/2;
                if(dp[pivot]<num) left = pivot+1;
                else right = pivot;
            }
            dp[left] = num;
            if(left==ans) ans++;
        }
        return ans;
    }
}