package com.jasper.algs.leetcode.backtracking.qu1329.solu1;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1329. 将矩阵按对角线排序
 * 
 * <p>聚类缓存并排序
 */
class Solution {
    public int[][] diagonalSort(int[][] mat) {
    	// 边界处理
    	if(mat==null || mat.length==0)
    		return mat;
    	
    	// 行列
    	int rows = mat.length;
    	int cols = mat[0].length;
    	
    	// 聚类缓存并排序
    	@SuppressWarnings("unchecked")
		Queue<Integer>[] helper = new Queue[rows+cols-1];
    	for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int diff = r-c + (cols-1);
				if(helper[diff]==null) helper[diff] = new PriorityQueue<Integer>();
				helper[diff].add(mat[r][c]);
			}
		}
    	
    	// 构造答案
    	for (int r = 0; r < rows; r++) {
    		for (int c = 0; c < cols; c++) {
    			int diff = r-c + (cols-1);
    			mat[r][c] = helper[diff].poll();
    		}
		}
    	
    	return mat;
    }
    
}