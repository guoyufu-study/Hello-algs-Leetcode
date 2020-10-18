package com.jasper.algs.contest.weekly.c083.qu0830.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0830. 较大分组的位置
 *
 * <p> 双指针
 */
class Solution {
	public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, n = S.length(); // left 是每组起始索引
        for (int right = 0; right < n; ++right) {
            if (right == n-1 || S.charAt(right) != S.charAt(right+1)) {
                // [left, right] 表示一个组
                if (right-left+1 >= 3)
                    ans.add(Arrays.asList(left, right));
                left = right + 1;
            }
        }

        return ans;
    }
}