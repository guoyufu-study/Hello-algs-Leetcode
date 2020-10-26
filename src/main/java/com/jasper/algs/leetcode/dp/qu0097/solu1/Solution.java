package com.jasper.algs.leetcode.dp.qu0097.solu1;

/**
 * 0097. 交错字符串
 * 
 * <p> 动态规划
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) return false;
        
        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                f[i][j] = f[i][j] || (i-1>=0 
                            && f[i - 1][j] 
                            && s1.charAt(i - 1) == s3.charAt(p))
                        || (j-1>=0 
                            && f[i][j - 1] 
                            && s2.charAt(j - 1) == s3.charAt(p));
            }
        }

        return f[n][m];
    }
}