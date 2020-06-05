package com.jasper.algs.leetcode.matrix.qu0054.solu;

import java.util.ArrayList;
import java.util.List;

/**
 * 0054. 螺旋矩阵
 * 
 * <p> 2刷
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

    	return new ArrayList<Integer>();
    }
    
    public static void main(String[] args) {
		
    	// [1,2,3,6,9,8,7,4,5]
    	int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
    	
    	// [1,2,3,4,8,12,11,10,9,5,6,7]
//    	int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	
    	
    	System.out.println(new Solution().spiralOrder(matrix));
	}
}