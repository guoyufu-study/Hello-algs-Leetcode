package com.jasper.algs.leetcode.matrix.qu0054.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0054. 螺旋矩阵
 * 
 * <p> 按层模拟
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	// 边界
    	if(matrix==null || matrix.length==0 || matrix[0].length==0) {
    		return new ArrayList<Integer>();
    	}
    	
    	// 起始标记
    	int rows = matrix.length, columns = matrix[0].length;
        int left=0, right=columns-1, top=0, bottom=rows-1;
        
    	ArrayList<Integer> order = new ArrayList<Integer>();
    	
    	while(left<=right && top<=bottom) {
    		// 上
    		for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }

    		// 右
    		for (int row = top+1; row <= bottom; row++) {
				order.add(matrix[row][right]);
			}
    		
    		if (left < right && top < bottom) { 
    			// 下
        		for (int column = right-1; column > left; column--) {
    				order.add(matrix[bottom][column]);
    			}
        		// 左
        		for (int row = bottom; row > top; row--) {
					order.add(matrix[row][left]);
				}
    		}
    		
    		// 下一层
    		left++;
            right--;
            top++;
            bottom--;
    	}
    	
		return order;
    }
    
    public static void main(String[] args) {
		
    	// [1,2,3,6,9,8,7,4,5]
//    	int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
    	
    	// [1,2,3,4,8,12,11,10,9,5,6,7]
    	int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	
    	
    	System.out.println(new Solution().spiralOrder(matrix));
	}
}