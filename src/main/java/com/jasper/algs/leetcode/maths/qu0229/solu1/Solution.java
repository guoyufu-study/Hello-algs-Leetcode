package com.jasper.algs.leetcode.maths.qu0229.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0229. 求众数 II
 * 
 * <p> 摩尔投票
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        // 默认候选人及得票
        int a = nums[0], p = 0;
        int b = nums[0], q = 0;
        for(int num : nums) {
            // 是候选人之一：累计得票
            if(num==a) p++;
            else if(num==b) q++;
            else { // 不是候选人
                // 更换候选人
                if(p==0) {
                    a = num;
                    p++;
                } else if(q==0) {
                    b = num;
                    q++;
                } else { // 抵消计票
                    p--;
                    q--;
                }
            }
        }

        // 确认有效
        p = 0;
        q = 0;
        for(int num : nums) {
            if(num==a) p++;
            else if(num==b) q++;
        }

        int limit = nums.length/3;
        if(p>limit) ans.add(a);
        if(q>limit) ans.add(b);
        return ans;
    }
}