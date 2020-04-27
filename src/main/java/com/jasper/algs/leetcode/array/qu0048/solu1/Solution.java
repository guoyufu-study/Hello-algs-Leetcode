package com.jasper.algs.leetcode.array.qu0048.solu1;

/**
 * 0048. 旋转图像
 * 
 * <p>旋转四个矩形
 */
class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2 + n % 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int[] tmp = new int[4];
				int row = i;
				int col = j;
				// 缓存
				for (int k = 0; k < 4; k++) {
					tmp[k] = matrix[row][col];
					int x = row;
					row = col;
					col = n - 1 - x;
				}
				// 旋转
				for (int k = 0; k < 4; k++) {
					matrix[row][col] = tmp[(k + 3) % 4];
					int x = row;
					row = col;
					col = n - 1 - x;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		new Solution().rotate(matrix);
	}
}