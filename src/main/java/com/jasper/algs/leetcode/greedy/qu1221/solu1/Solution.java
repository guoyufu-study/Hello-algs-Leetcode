package com.jasper.algs.leetcode.greedy.qu1221.solu1;

/**
 * 贪心算法
 */
class Solution {
    public int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                num++;
            else
                num--;
            if(num == 0)
                res++;
        }
        return res;

    }
}