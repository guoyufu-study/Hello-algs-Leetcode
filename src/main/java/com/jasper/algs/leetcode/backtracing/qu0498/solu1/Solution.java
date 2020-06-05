package com.jasper.algs.leetcode.backtracing.qu0498.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0498. 对角线遍历
 *
 * <p>数组聚类+翻转
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    	
    	// 边界处理
    	if(matrix==null || matrix.length==0)
    		return new int[0];
    	int rows = matrix.length;
    	int cols = matrix[0].length;
    	
    	// 辅助数组聚类
    	@SuppressWarnings("unchecked")
		List<Integer>[] helper = new List[rows+cols-1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int k = i+j;
				if(helper[k]==null) helper[k] = new ArrayList<Integer>();
				helper[k].add(matrix[i][j]);
			}
		}
		
		// 构造答案
		int[] ans = new int[rows*cols];
		int i = 0;
		for (int k = 0; k < helper.length; k++) {
			if(k%2==0) // 偶数，先进后出
				for (int j = helper[k].size()-1; j >= 0; j--) {
					ans[i++] = helper[k].get(j);
				}
			else // 奇数，先进先出
				for (int j = 0; j < helper[k].size(); j++) {
					ans[i++] = helper[k].get(j);
				}
		}
		
		return ans;
    }
}