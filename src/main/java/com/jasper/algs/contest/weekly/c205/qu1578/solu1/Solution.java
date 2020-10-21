package com.jasper.algs.contest.weekly.c205.qu1578.solu1;

/**
 * 1578. 避免重复字母的最小删除成本
 * 
 * <p> 贪心算法
 */
class Solution {
    public int minCost(String s, int[] cost) {
    	int i = 0, n = s.length();
        int ans = 0;
        while (i < n) {
            char ch = s.charAt(i);
            int maxValue = 0;
            int sum = 0;

            while (i < n && s.charAt(i) == ch) {// 保留重复元素中的最大值，删除其他所有重复元素
                maxValue = Math.max(maxValue, cost[i]);
                sum += cost[i];
                i++;
            }
            ans += (sum - maxValue);
        }
        return ans;
    }
}