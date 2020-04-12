package com.jasper.algs.leetcode.greedy.qu0013.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用HashMap
 */
class Solution {
	
	private static final Map<Character, Integer> map;
	
	static {
		map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	
    public int romanToInt(String s) {
        int ans = 0;
        int prev = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
			int num = map.get(s.charAt(i));
			ans = prev>=num?ans+prev:ans-prev;
			prev = num;
        	
		}
        ans += prev;
        return ans;
    }

 
 
    public static void main(String[] args) {
		
	}

}