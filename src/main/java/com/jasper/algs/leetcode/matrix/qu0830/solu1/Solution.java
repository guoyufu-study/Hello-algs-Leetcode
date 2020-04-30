package com.jasper.algs.leetcode.matrix.qu0830.solu1;

/**
 * 0832. 翻转图像
 * 
 * <p> 模拟翻转流程
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
    	
    	int N = A.length;
    	// 翻转图像
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N/2; c++) {
				int tmp = A[r][c];
				A[r][c] = A[r][N-1-c];
				A[r][N-1-c] = tmp;
			}
		}
    	
    	// 反转图像
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				A[r][c] = A[r][c] ^ 1;// 1=>0; 0=>1
			}
		}
    	return A;
    }
}