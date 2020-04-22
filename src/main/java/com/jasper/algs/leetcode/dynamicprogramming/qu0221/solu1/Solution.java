package com.jasper.algs.leetcode.dynamicprogramming.qu0221.solu1;

/**
 * 暴力求解（优化）
 * 
 * <p>
 * 构造所有可能的正方形，并判断。
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
    	
    	// 边界
    	if(matrix.length==0) return 0;
    	
    	int rows = matrix.length,
    		cols = matrix[0].length;// 行列
    	
        int ans = 0;//正方形边长
        for (int i = 0; i < rows-ans;/* 优化1：跳过可能存在的较小正方形*/ i++) {
			for (int j = 0; j < cols-ans; j++) {// 左上顶点
				
				if(matrix[i][j]=='0') continue; // 优化2：跳过为0的左上顶点
				
				//正方形初始边长 1
				if(1 > ans) ans = 1;//更新最大边长
				
				int m = i, n = j;//右下顶点
				int threshold = Math.min(rows-i, cols-j);//正方形可能的最大边长
				nextNode:
				for (int size = 1; size < threshold;) { // 检查边长+1，是否也能构成更大正方形
					m = i+size;
					n = j+size;
					if(matrix[m][n]=='0') break;//换一个左上顶点
					
					int p = j; 
					while(p<n)
						if(matrix[m][p++] == '0') break nextNode;//换一个左上顶点
					
					p = i;
					while(p<m)
						if(matrix[p++][n] == '0') break nextNode;//换一个左上顶点
					
					size++;
					if(size > ans) ans = size;//能构成更大正方形，更新最大边长
				}
				
			}
		}
       
        
        return ans * ans;
    }
}