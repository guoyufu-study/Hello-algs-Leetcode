package com.jasper.algs.contest.weekly.c207.qu1593.solu2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 1593. 拆分字符串使唯一子字符串的数目最大
 * 
 * <p> DFS 暴力枚举
 */
class Solution {
    String s;
    int n;
    public int maxUniqueSplit(String s) {
        this.s = s;
        n = s.length();
        return dfs(0, String.valueOf(s.charAt(0)));
    }

    int dfs(int index, String memo) {
        if(index == n-1) {
            return new HashSet<String>(Arrays.asList(memo.split(" "))).size();
        }
        index++;
        return Math.max(
            dfs(index, memo+s.charAt(index)), // 数目不变或缩短
            dfs(index, memo+" "+s.charAt(index))); // 数目增加或不变
    }
}