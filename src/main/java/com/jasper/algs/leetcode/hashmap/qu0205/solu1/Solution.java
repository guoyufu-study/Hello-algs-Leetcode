package com.jasper.algs.leetcode.hashmap.qu0205.solu1;

import java.util.HashMap;

/**
 * 0205. 同构字符串
 * 
 * <p> 映射
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
    	return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}