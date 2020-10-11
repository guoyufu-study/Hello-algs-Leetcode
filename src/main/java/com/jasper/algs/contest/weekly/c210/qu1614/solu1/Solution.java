package com.jasper.algs.contest.weekly.c210.qu1614.solu1;

/**
 * 1614. 括号的最大嵌套深度
 * 
 * <p> 简单计数
 */
class Solution {
    public int maxDepth(String s) {
        int ans = 0, cnt = 0;
        for(char c : s.toCharArray()) {
            if(c=='(') {
                cnt++;
                ans = Math.max(ans, cnt);
            } else if(c==')') cnt--;
        }
        return ans;
    }
}