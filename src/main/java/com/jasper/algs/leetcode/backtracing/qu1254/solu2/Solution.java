package com.jasper.algs.leetcode.backtracing.qu1254.solu2;

import java.util.Stack;

/**
 * 1254. 统计封闭岛屿的数目
 *	
 * <p> DFS 非递归
 */
class Solution {
    public int closedIsland(int[][] grid) {
    	int M = grid.length;
    	if(M<=2) return 0;// 边界
    	int N = grid[0].length;
    	
    	int ans = 0;
    	// 辅助栈
		Stack<int[]> helper = new Stack<int[]>();
    	for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				// 跳过水域
				if(grid[r][c]==1) continue;
				
				boolean isClosedIsland = true; // 标识是否封闭岛屿，默认非封闭

				// DFS 并标记已遍历
				helper.push(new int[] {r, c});
				while(!helper.isEmpty()) {
					int[] tmp = helper.pop();
					
					// 非封闭岛屿
					if((tmp[0]==0 || tmp[0]==M-1 || tmp[1]==0 || tmp[1]==N-1) 
							&& grid[tmp[0]][tmp[1]]==0) {
						isClosedIsland = false;
						continue;
					}
					
					// 跳过水域
					if(grid[tmp[0]][tmp[1]]==1) continue;
					
					// 标记已遍历
					grid[tmp[0]][tmp[1]]=1;
					
					// 入栈
					helper.push(new int[] {tmp[0]-1, tmp[1]});
					helper.push(new int[] {tmp[0]+1, tmp[1]});
					helper.push(new int[] {tmp[0], tmp[1]-1});
					helper.push(new int[] {tmp[0], tmp[1]+1});
				}
				
				// 记录封闭岛屿
				if (isClosedIsland) ans++;
			}
		}
    	
    	return ans;
    }
}