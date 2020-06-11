package com.jasper.algs.leetcode.string.qu0028.solu3;

/**
 * 0028. 实现 strStr()
 * 
 * <p> Rabin-Karp 查找算法
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();
        if(L>n) return -1;
        
        // 滚动哈希函数的基值
        int a = 26;
        // 为滚动哈希函数设置模量，以避免溢出
        long mod = (long) Math.pow(2, 31);
        
        // 计算 haystack[:L], needle[:L] 的 hash
        long h = 0, ref_h=0;
        for (int i = 0; i < L; i++) {
			h = (h*a + charToInt(i, haystack)) % mod;
			ref_h = (ref_h*a + charToInt(i, needle)) % mod;
		}
        if(h==ref_h) return 0;
        
        // 常用常量值: (aL * a) % mod
        long aL = 1;
        for (int i = 1; i <= L; i++) {
			aL = (aL * a) % mod;
		}
        
        for (int start = 1; start < n - L + 1; start++) {
        	// 计算滚动哈希
			h = (h * a - charToInt(start-1, haystack) * aL + charToInt(start+L-1, haystack)) % mod;
			if(h==ref_h) return start;
		}
    	return -1;
    }

    // 字符串转成int
	private int charToInt(int idx, String s) {
		return (int)s.charAt(idx) - (int)'a';
	}
}