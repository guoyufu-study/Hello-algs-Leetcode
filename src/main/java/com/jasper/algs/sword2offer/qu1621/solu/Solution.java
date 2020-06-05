package com.jasper.algs.sword2offer.qu1621.solu;

import java.util.stream.IntStream;

/**
 * 1621.面试题29. 顺时针打印矩阵
 * 
 * <p> 2 刷
 */
class Solution {
	public int[] spiralOrder(int[][] matrix) {
    	
    	
    	return new int[0];
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