package com.jasper.algs.contest.biweekly.bc03.qu1100.solu1;

/**
 * 1100. 长度为 K 的无重复字符子串
 * 
 * <p> 滑动窗口
 */
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int n = S.length();
        if(n < K) return 0;
        // 26 个小写英文字母
        int[] map = new int[26];
        int s = 0, e = 0, ans = 0;
        while(e < n) {
            int ch = S.charAt(e) - 'a';
            if(map[ch]>0) 
                s = Math.max(map[ch], s); // 收缩窗口
            // 扩展窗口
            map[ch] = ++e;
            if(K==e-s) { 
                ans++; // 更新答案
                s++; // 收缩窗口
            }
        }

        return ans;
    }
}