package com.jasper.algs.leetcode.twopointers.qu0259.solu3;

import java.util.Arrays;

/**
 * 0259. 较小的三数之和
 * 
 * <p> 左右指针
 */
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for(int i=0; i+2<n; i++) {
            if(nums[i]+nums[i+1]+nums[i+2] >= target) return ans;
            int left=i+1, right=n-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    ans += right-left;// right 可选方案
                    left++;
                }
                else if(sum >= target) right--;
            }
        }

        return ans;
    }
}