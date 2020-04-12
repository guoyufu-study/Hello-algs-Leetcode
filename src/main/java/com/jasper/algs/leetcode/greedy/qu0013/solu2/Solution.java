package com.jasper.algs.leetcode.greedy.qu0013.solu2;

/**
 * 替代HashMap
 *
 */
class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int prev = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            ans = prev<num?ans-prev:ans+prev;
            prev = num;
        }
        ans += prev;
        return ans;
    }
    
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
