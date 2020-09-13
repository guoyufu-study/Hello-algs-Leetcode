package com.jasper.algs.leetcode.hashmap.qu0205.solu2;

/**
 * 0205. 同构字符串
 * 
 * <p>
 * 映射
 */
class Solution {
	public boolean isIsomorphic(String s, String t) {
		int n = s.length();
		int[] mapS = new int[128];
		int[] mapT = new int[128];
		for (int i = 0; i < n; i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			// 映射值不同
			if (mapS[c1] != mapT[c2]) 
				return false;
			
			// 修改
			if (mapS[c1] == 0) {
				mapS[c1] = i + 1;
				mapT[c2] = i + 1;
			}
		}
		return true;
	}
}