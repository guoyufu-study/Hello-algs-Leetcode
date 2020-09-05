package com.jasper.algs.contest.biweekly.bc34.qu1572.solu1;

/**
 * 1572. 矩阵对角线元素的和
 * 
 * <p> 累加去心
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            int j = i;// 主对角线
            ans += mat[i][j];
            j = n-1-i;// 副对角线
            ans += mat[i][j];
        }

        // 边长为奇数的正方形矩阵，多加了一次中心元素。
        if(n%2==1) ans -= mat[n/2][n/2];
        
        return ans;
    }
}