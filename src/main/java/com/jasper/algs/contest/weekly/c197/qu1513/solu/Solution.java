package com.jasper.algs.contest.weekly.c197.qu1513.solu;

/**
 * 1513. 仅含 1 的子串数
 * 
 * <p> 3 刷
 */
class Solution {

	private static final int mod = 1_000_000_007;
	
	public int numSub(String s) {
		
		int ans = 0, count = 0;
		for(char c : s.toCharArray()) {
			if(c=='1') count++;
			else {
				ans += (count+1) * count / 2;
				ans %= mod;
				count = 0;
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		String s = "0110111";
		System.out.println(new Solution().numSub(s));
	}
}
