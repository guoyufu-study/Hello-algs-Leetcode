package com.jasper.algs.leetcode.backtracking.qu0498.solu2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 0498. 对角线遍历
 *
 * <p>对角线迭代+翻转
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    	
    	// 边界处理
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        // 跟踪矩阵的大小
        int N = matrix.length;
        int M = matrix[0].length;
        
        // 答案数组 + 辅助列表
        int[] ans = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();
        
        // 我们必须遍历第一行和最后一列中的所有元素，以覆盖所有可能的对角线
        for (int d = 0; d < N + M - 1; d++) {
            
            // 每次开始处理另一条对角线时清除中间数组
            intermediate.clear();
            
            // 我们需要算出这条对角线的起点
            // 第一行和最后一列中的所有元素
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;
            
            // 迭代，直到其中一个索引超出范围
            // 注意索引沿着对角线计算
            while (r < N && c > -1) {
                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }
                
            // 反转相应对角线
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }
            
            // 构造答案
            for (int i = 0; i < intermediate.size(); i++) {
                ans[k++] = intermediate.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		new Solution().findDiagonalOrder(matrix);
	}
}