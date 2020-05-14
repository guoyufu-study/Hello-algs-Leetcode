package com.jasper.algs.leetcode.bitmanipulation.qu0389.solu5;

/**
 * 位运算: 卡诺图生成状态转移公式
 */
public class Solution {

	public char findTheDifference(String s, String t) {
		int ans=0;
		
		int N = s.length();
		for (int i = 0; i < N; i++) {
			ans  = (~ans & s.charAt(i)) + (ans & ~s.charAt(i)); //状态转移公式
			ans  = (~ans & t.charAt(i)) + (ans & ~t.charAt(i));
		}
		ans  = (~ans & t.charAt(N)) + (ans & ~t.charAt(N));
		return (char)ans;
    }
}
