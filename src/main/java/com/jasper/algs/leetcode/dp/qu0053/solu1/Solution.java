package com.jasper.algs.leetcode.dp.qu0053.solu1;

/**
 * 0053. 最大子序和
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length, ans = Integer.MIN_VALUE;
        // 暴力枚举
//        for(int i=0; i<n; i++) {
//            for(int j=i; j<n; j++) {
//                int sum = 0;
//                for(int k=i; k<=j; k++) {
//                    sum += nums[k];
//                }
//                if(ans < sum)
//                    ans = sum;
//            }
//        }
        
        // 简单优化
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {
                sum += nums[j];
                if(ans < sum)
                    ans = sum;
            }
        }

        return ans;
    }
}