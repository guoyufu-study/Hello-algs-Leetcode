package com.jasper.algs.leetcode.hashmap.qu1189.solu1;

/**
 * 1189. “气球” 的最大数量
 * 
 * <p> 字典计数
 */
class Solution {
    public int maxNumberOfBalloons(String text) {

    	int[] map = new int[26];
        for(char c : text.toCharArray()) {
            map[c-'a']++;
        }
        
        int ans = 0;
        ans = Math.min(map['b'-'a'], map['a'-'a']);
        ans = Math.min(ans, map['l'-'a']/2);
        ans = Math.min(ans, map['o'-'a']/2);
        ans = Math.min(ans, map['n'-'a']);

        return ans;
    }
}