package com.jasper.algs.leetcode.dp.qu0085.solu3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 0085. 最大矩形
 *
 * <p>动态规划：优化柱状图
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
    	// 边界
    	if(matrix.length == 0) return 0;
    	
    	int n = matrix.length, m = matrix[0].length, ans = 0;
    	
    	// 辅助数组
    	int[] dp = new int[m];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {// 定位矩形右下角
				// 更新高度
				dp[j] = matrix[i][j] == '0'? 0 : dp[j] + 1;
			}
    		// 更新面积
    		ans = Math.max(ans, leetcode84(dp));
		}
    	
    	return ans;
    }
    
    /**
     * 优化柱状图
     * @param heights
     * @return
     */
    public int leetcode84(int[] heights) {
        Deque <Integer> stack = new LinkedList<> ();// 单调栈
        stack.push(-1);// 哨兵
        
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
        	
        	// 当前柱子为右边界，求矩形面积
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            
            // 入栈
            stack.push(i);
        }
        
        // 最右侧柱子作为右边界，求矩形面积
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        
        // 最大面积
        return maxarea;
    }
    
    public static void main(String[] args) {
    	char[][] matrix = new char[][] {
    		{'1','0','1','0','0'},
    		{'1','0','1','1','1'},
    		{'1','1','1','1','1'},
    		{'1','0','0','1','0'}
    		};
    	
    	new Solution().maximalRectangle(matrix);
	}
}