package com.jasper.algs.leetcode.matrix.qu0059.solu2;

import java.util.Arrays;

/**
 * 0059. 螺旋矩阵 II
 * 
 * <p> 按层模拟
 */
class Solution {
	public int[][] generateMatrix(int n) {

		
		int[][] matrix = new int[n][n];
		// 起始标记
		int left=0, right=n-1, top=0, bottom=n-1;
		// 值
		int num = 1;
		while(left<=right && top<=bottom) {
			
			// 上
			for (int column = left; column <= right; column++) {
				matrix[top][column] = num++;
			}
			
			// 右
			for (int row = top+1; row <= bottom; row++) {
				matrix[row][right] = num++;
			}
			
			if(left<right && top<bottom) {
				// 下
				for (int column = right-1; column > left; column--) {
					matrix[bottom][column] = num++;
				}
				
				// 左
				for (int row = bottom; row > top; row--) {
					matrix[row][left] = num++;
				}
			}
			
			// 下一层
			left++;
			right--;
			top++;
			bottom--;
		}
    	return matrix;
    }
    
    public static void main(String[] args) {
		
//    	[
//    	 [ 1, 2, 3 ],
//    	 [ 8, 9, 4 ],
//    	 [ 7, 6, 5 ]
//    	]
    	int n = 3;
    	
    	Arrays.stream(new Solution().generateMatrix(n))
    		.flatMapToInt(Arrays::stream)
    		.forEach(x -> System.out.print(x + ","));
	}
}