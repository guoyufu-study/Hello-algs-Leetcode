package com.jasper.algs.contest.weekly.c207.qu1593.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 1593. 拆分字符串使唯一子字符串的数目最大
 * 
 * <p> 回溯
 */
class Solution {
    int ans;
    String s;
    int n;
    public int maxUniqueSplit(String s) {
        // 贪心不可以
        this.s = s;
        n = s.length();
        ans = 0;
        
        dfs(0, new HashSet<String>());
        
        return ans;
        
    }
    
    void dfs(int beginIndex, Set<String> memo) {
        if(beginIndex==n) {
            ans = Math.max(ans, memo.size());
        }
        int endIndex = beginIndex+1;
        while(endIndex<=n) {
            String sub = s.substring(beginIndex,endIndex);
            if(!memo.contains(sub)) {
                memo.add(sub);
                dfs(endIndex, memo);
                memo.remove(sub);
            }
            endIndex++;
        }
        
    }
               
        
}