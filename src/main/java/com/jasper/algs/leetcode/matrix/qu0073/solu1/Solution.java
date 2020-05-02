package com.jasper.algs.leetcode.matrix.qu0073.solu1;

/**
 * 0073. 矩阵置零
 * 
 * <p>1. 额外空间记录置0行列
 */
class Solution {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null || matrix.length==0) 
    		return ;
    	
    	int N = matrix.length;
    	int M = matrix[0].length;
    	
    	// 辅助数组
    	boolean[] rows = new boolean[N];
    	boolean[] cols = new boolean[M];
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
    	
    	// 矩阵置0
    	for (int i = 0; i < N; i++) { // 行
			if(rows[i])
				for (int j = 0; j < M; j++) {
					matrix[i][j] = 0;
				}
		}
    	for (int j = 0; j < M; j++) { // 列
			if(cols[j]) 
				for (int i = 0; i < N; i++) {
					matrix[i][j] = 0;
				}
		}
    }
}