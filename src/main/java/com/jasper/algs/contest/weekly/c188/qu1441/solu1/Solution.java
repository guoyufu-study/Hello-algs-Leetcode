package com.jasper.algs.contest.weekly.c188.qu1441.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 *
 * <p> 双指针 + 贪心
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        int m = target.length;
        List<String> ans = new ArrayList<>();
        for(int i = 0, j = 1; i < m; i++) {
            int limit = target[i];
            while(j<limit) {
                ans.add("Push");
                ans.add("Pop");
                j++;
            }
            ans.add("Push");
            j++;
        }

        return ans;
    }
}