package com.jasper.algs.leetcode.interval.qu0228.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0228. 汇总区间
 * 
 * <p> 滑动窗口
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            if (right + 1 == n || nums[right] + 1 != nums[right + 1]) {
                ans.add(String.valueOf(nums[left]) + (left == right ? "" : "->" + String.valueOf(nums[right])));
                left = right + 1;
            }
            right++;
        }
        return ans;
    }
}