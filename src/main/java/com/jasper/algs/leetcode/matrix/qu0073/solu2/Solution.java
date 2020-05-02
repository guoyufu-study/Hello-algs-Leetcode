package com.jasper.algs.leetcode.matrix.qu0073.solu2;

/**
 * 0073. 矩阵置零
 * 
 * <p>1. 矩阵自身记录置0行列
 */
class Solution {
    public void setZeroes(int[][] matrix) {
    	// 边界
    	if(matrix == null || matrix.length==0) 
    		return ;
    	
    	int N = matrix.length;
    	int M = matrix[0].length;
    	
    	boolean col0 = false;
    	// 哪行哪列置0
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(matrix[i][j]!=0) continue;
				if(j==0) {
					matrix[i][0] = 0;
					col0 = true;// 第一列是否置0
				} else {
					matrix[i][0] = 0; // i行置0
					matrix[0][j] = 0; // j列置0
				}
			}
		}
    	
    	// 矩阵置0
    	for (int j = 1; j < M; j++) { // 列
			if(matrix[0][j] == 0)
				for (int i = 1; i < N; i++) {
					matrix[i][j] = 0;
				}
		}
    	for (int i = 0; i < N; i++) { // 行
			if(matrix[i][0] == 0)
				for (int j = 1; j < M; j++) {
					matrix[i][j] = 0;
				}
		}
    	if(col0) // 第0列
    		for (int i = 0; i < N; i++) {
				matrix[i][0] = 0;
			}
    	
    }
    
    public static void main(String[] args) {
    	int[][] matrix = new int[][] {{1,1,1},{0,1,2}};
//    	int[][] matrix = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
    	
    	new Solution().setZeroes(matrix);
	}
}