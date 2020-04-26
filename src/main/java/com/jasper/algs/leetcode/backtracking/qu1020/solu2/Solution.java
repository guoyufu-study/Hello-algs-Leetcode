package com.jasper.algs.leetcode.backtracking.qu1020.solu2;

import java.util.Stack;

/**
 * 1020. 飞地的数量
 *	
 * <p>DFS 非递归
 */
class Solution {
    public int numEnclaves(int[][] A) {
    	// 边界
    	int rows = A.length;
    	if(rows<=2) return 0;
    	int cols = A[0].length;
    	if(cols<=2) return 0;
    	
    	int ans = 0;
    	// 辅助栈
    	Stack<int[]> helper = new Stack<int[]>();
    	//遍历
    	for (int r = 1; r < rows-1; r++) {
    		for (int c = 1; c < cols-1; c++) {
				// 跳过水域
    			if(A[r][c] == 0) continue;
    			
    			// 统计飞地数量
    			int count = 0;
    			// DFS
    			helper.push(new int[] {r, c});
    			while(!helper.isEmpty()) {
    				int[] tmp = helper.pop();
    				// 遇到边界终止
    				if((tmp[0]==0 || tmp[0]==rows-1 || tmp[1]==0 || tmp[1]==cols-1) && A[tmp[0]][tmp[1]] == 1) {
    					count = -250000;
    					continue;
    				}
    				
    				// 遇到水域终止
    				if(A[tmp[0]][tmp[1]] == 0) continue;
    				
    				// 标记已遍历
    				A[tmp[0]][tmp[1]] = 0;
    				
    				// 统计飞地
    				count++;
    				
    				// 入栈
    				helper.push(new int[] {tmp[0]-1, tmp[1]});
    				helper.push(new int[] {tmp[0]+1, tmp[1]});
    				helper.push(new int[] {tmp[0], tmp[1]-1});
    				helper.push(new int[] {tmp[0], tmp[1]+1});
    			}
    			ans += count < 0 ? 0 : count;
			}
		}
    	
    	return ans;
    }

}