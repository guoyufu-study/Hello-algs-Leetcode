package com.jasper.algs.leetcode.matrix.qu0059.solu;

import java.util.Arrays;

/**
 * 0059. 螺旋矩阵 II
 * 
 * <p> 2刷
 */
class Solution {
	public int[][] generateMatrix(int n) {

    	return new int[0][0];
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