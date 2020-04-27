package com.jasper.algs.leetcode.array.qu0048.solu4;

import java.util.Arrays;

/**
 * 0048. 旋转图像
 * 
 * <p>顺时针转90度 => 先上下翻转，再左上右下对角翻转
 */
class Solution {
    public void rotate(int[][] matrix) {
    	// 上下翻转
    	int length = matrix.length;
		for (int i = 0; i < length/2; i++) {
    		int[] temp = matrix[i];
    		matrix[i] = matrix[length-1-i];
    		matrix[length-1-i] = temp;
		}
    	
    	// 左上右下对角翻转
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix.length; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
		
		Arrays.stream(matrix).forEach((nums)-> {
			Arrays.stream(nums).forEach((x) -> System.out.print(x+"\t"));
			System.out.println();
		});
    }
    
    public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		new Solution().rotate(matrix);
	}
}