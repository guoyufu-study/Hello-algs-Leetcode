package com.jasper.algs.leetcode.matrix.qu0830.solu2;

/**
 * 0832. 翻转图像
 * 
 * <p> 一步到位
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
    	
    	int N = A.length;
    	
    	// 翻转图像->反转图像  => A[i][j] = A[i][N-1-j] ^ 1
    	for (int r = 0; r < N; r++) {
			for (int c = 0; c < (N+1)/2; c++) {
				int tmp = A[r][c] ^ 1;
				A[r][c] = A[r][N-1-c] ^ 1;
				A[r][N-1-c] = tmp;
			}
		}
    	
    	return A;
    }
    
    public static void main(String[] args) {
    	//                      [[1, 0, 0], [0, 1, 0], [1, 1, 1]]
		int[][] A = new int[][] {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
		
		new Solution().flipAndInvertImage(A);

	}
}