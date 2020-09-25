package com.jasper.algs.contest.weekly.c206.qu1582.solu2;

/**
 * 1582. 二进制矩阵中的特殊位置
 * 
 * <p>行和列和元素值都是1
 */
class Solution {
    public int numSpecial(int[][] mat) {
    	int n = mat.length, m = mat[0].length;
        // 求每一行，每一列的和
        int[] rows = new int[n], cols = new int[m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                rows[i] += mat[i][j];
                cols[j] += mat[i][j];
            }
        }

        // 行和、列和都为1，且元素值为 1，即为特殊位置
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(rows[i]!=1) continue;
            for(int j=0; j<m; j++) {
                if(cols[j]!=1) continue;
                if(mat[i][j]==1) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}