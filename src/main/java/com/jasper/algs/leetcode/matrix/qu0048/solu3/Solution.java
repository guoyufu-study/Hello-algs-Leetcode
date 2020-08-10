package com.jasper.algs.leetcode.matrix.qu0048.solu3;

import java.util.Arrays;

/**
 * 0048. 旋转图像
 * 
 * <p>
 * 旋转外框
 */
class Solution {
	public void rotate(int[][] matrix) {
		int temp = -1;
		for (int start = 0, end = matrix[0].length - 1; start < end; start++, end--) {
			for (int s = start, e = end; s < end; s++, e--) {
				temp = matrix[start][s];
				matrix[start][s] = matrix[e][start];
				matrix[e][start] = matrix[end][e];
				matrix[end][e] = matrix[s][end];
				matrix[s][end] = temp;
			}
		}

		Arrays.stream(matrix).forEach((nums) -> {
			Arrays.stream(nums).forEach((x) -> System.out.print(x + "\t"));
			System.out.println();
		});
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		new Solution().rotate(matrix);
	}
}