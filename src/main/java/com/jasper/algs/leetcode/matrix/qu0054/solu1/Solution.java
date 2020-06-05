package com.jasper.algs.leetcode.matrix.qu0054.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0054. 螺旋矩阵
 * 
 * <p> 模拟
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	// 边界
    	if(matrix==null || matrix.length==0 || matrix[0].length==0) {
    		return new ArrayList<Integer>();
    	}
    	
    	// 结束标记
    	int rows = matrix.length, columns = matrix[0].length;
        int total = rows * columns;
        // 标记已遍历
        boolean[][] visited = new boolean[rows][columns];
    	// 起始索引
    	int row=0, column=0;
    	// 方向
    	int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    	int directionIndex = 0;
    	
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	
    	for (int i = 0; i < total; i++) {
    		// 记录
			ans.add(matrix[row][column]);
			
			// 标记已遍历
			visited[row][column] = true;
			
			// 转向
			int nextRow = row + directions[directionIndex][0];
			int nextColumn = column + directions[directionIndex][1];
			if(nextRow<0 || nextRow>=rows // 行越界
					|| nextColumn<0 || nextColumn>=columns // 列越界
					|| visited[nextRow][nextColumn]) // 已访问过
				directionIndex = (directionIndex+1)%4;
			
			// 下一个点
			row += directions[directionIndex][0];
			column += directions[directionIndex][1];
		}
    	
		return ans;
    }
    
    public static void main(String[] args) {
		
    	// [1,2,3,6,9,8,7,4,5]
//    	int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
    	
    	// [1,2,3,4,8,12,11,10,9,5,6,7]
    	int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	
    	
    	System.out.println(new Solution().spiralOrder(matrix));
	}
}