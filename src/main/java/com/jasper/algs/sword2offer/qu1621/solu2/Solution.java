package com.jasper.algs.sword2offer.qu1621.solu2;

import java.util.stream.IntStream;


/**
 * 1621.面试题29. 顺时针打印矩阵
 * 
 * <p> 按层模拟
 */
class Solution {
	public int[] spiralOrder(int[][] matrix) {
    	
    	// 边界
    	if(matrix==null || matrix.length==0 || matrix[0].length==0) {
    		return new int[0];
    	}
    	
    	// 起始标记
    	int rows = matrix.length, columns = matrix[0].length;
    	int total = rows * columns;
    	int left=0, right=columns-1, top=0, bottom=rows-1;
    	
    	int[] ans = new int[total];
    	int i = 0;
    	while(left<=right && top<=bottom) {
    		// 上
    		for (int column = left; column <= right; column++) {
				ans[i++] = matrix[top][column]; 
			}
    		
    		// 右
    		for (int row = top+1; row <= bottom; row++) {
				ans[i++] = matrix[row][right];
			}
    		
    		if(left<right && top<bottom) {
    			// 下
    			for (int column = right-1; column > left; column--) {
					ans[i++] = matrix[bottom][column];
				}
    			
    			// 左
    			for (int row = bottom; row > top; row--) {
					ans[i++] = matrix[row][left];
				}
    		}
    		
    		// 下一层
    		left++;
    		right--;
    		top++;
    		bottom--;
    	}
    	
    	return ans;
    }
	
	public static void main(String[] args) {
		
    	// [1,2,3,6,9,8,7,4,5]
//    	int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
    	
    	// [1,2,3,4,8,12,11,10,9,5,6,7]
    	int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	
    	IntStream.of(new Solution().spiralOrder(matrix))
    		.forEach(x -> System.out.print(x + ","));
	}
}