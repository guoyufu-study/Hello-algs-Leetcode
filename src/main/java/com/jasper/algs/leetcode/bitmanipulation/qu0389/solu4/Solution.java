package com.jasper.algs.leetcode.bitmanipulation.qu0389.solu4;

/**
 * 位运算: 位掩码-异或
 */
public class Solution {

	public char findTheDifference(String s, String t) {
		
		int seenOnce=0;
		int N = s.length();
		for (int i = 0; i < N; i++)
			seenOnce ^= s.charAt(i) ^ t.charAt(i); //位掩码-异或
		seenOnce ^= t.charAt(N);
		
		return (char)seenOnce;
    }
}
