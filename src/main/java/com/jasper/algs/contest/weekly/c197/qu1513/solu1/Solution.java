package com.jasper.algs.contest.weekly.c197.qu1513.solu1;

/**
 * 1513. 仅含 1 的子串数
 * 
 * <p> 简单计算
 */
class Solution {

	private static final int mod = 1_000_000_007;
	public int numSub(String s) {
		
		char[] sc = s.toCharArray();
		int ans = 0, count = 0;
		for (char c : sc) {
			if(c=='1') {
				ans += ++count;
//				ans %= mod;
				if (ans >= mod) {
                    ans -= mod;
                }
			} else {
				count=0;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		String s = "0110111";
		System.out.println(new Solution().numSub(s));
	}
}
