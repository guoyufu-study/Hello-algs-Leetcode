package com.jasper.algs.leetcode.twopointers.qu0259.solu1;

import java.util.Arrays;

/**
 * 0259. 较小的三数之和
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for(int i=0; i+2<n; i++) {
            if(nums[i]+nums[i+1]+nums[i+2] >= target) return ans;
            for (int j = i+1; j+1 < n; j++) {
				int sum = nums[i] + nums[j];
				if(sum + nums[j+1] >= target) break;
				for (int k = j+1; k < n; k++) {
					if(sum+nums[k] < target) ans++;
				}
			}
        }

        return ans;
    }
}