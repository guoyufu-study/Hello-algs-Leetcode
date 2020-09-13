package com.jasper.algs.leetcode.twopointers.qu0259.solu2;

import java.util.Arrays;

/**
 * 0259. 较小的三数之和
 * 
 * <p> 二分查找
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
				int left=j+1, right=n-1;
				while(left < right) {
					int mid = (left + right + 1)/2;
					int sum3 = sum + nums[mid];
					if(sum3 < target) left = mid;
					else right = mid - 1;
				}
				ans += left - j;
			}
        }

        return ans;
    }
}