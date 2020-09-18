package com.jasper.algs.leetcode.backtracing.qu0090.solu3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 0090. 子集 II
 * 
 * <p> 逐渐增加长度：回溯
 */
class Solution {
    int[] nums;
    int n, len;
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        ans = new ArrayList<>();
        
        // dfs
        for(len=0; len<=n; len++) {
            dfs(0, new LinkedList<Integer>());
        }

        return ans;
    }

    void dfs(int start, List<Integer> memo) {
        if(memo.size() == len) {
            ans.add(new ArrayList<>(memo));
            return ;
        }
        
        // 选择
        for(int i=start; i<n; i++) {
            if(i > start && nums[i]==nums[i-1]) continue; // 去重
            memo.add(nums[i]);
            dfs(i+1, memo);
            memo.remove(memo.size()-1);
        }
    }
}