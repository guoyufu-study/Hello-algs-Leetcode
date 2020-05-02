package com.jasper.algs.leetcode.dynamicprogramming.qu0828.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0828. 统计子串中的唯一字符
 * 
 * <p> 官方答案：对于每个字母分别计数
 */
class Solution {
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }
    
    public static void main(String[] args) {
//		String s = "AA";
		String s = "LEETCODE";
//		String s = "ABA";
//		String s = "ABC";
		
		System.out.println(new Solution().uniqueLetterString(s));
	}
}