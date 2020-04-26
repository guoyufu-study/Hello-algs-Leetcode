package com.jasper.algs.leetcode.backtracking.qu0200.solu2;

import java.util.Stack;

/**
 * 0200. 岛屿数量
 *
 * <p> DFS 非递归：辅助栈
 */
class Solution {
    public int numIslands(char[][] grid) {
    	
    	int M = grid.length;
    	// 边界
    	if(M<1) return 0;
    	int N = grid[0].length;
    	
    	int ans = 0;
    	Stack<int[]> helper = new Stack<>();
    	for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				// 跳过水域
				if(grid[r][c] == '0') continue;
				
				// DFS 标记已遍历
				helper.push(new int[] {r, c});
				while(!helper.isEmpty()) {
					int[] tmp = helper.pop();
					// 跳过
					if(tmp[0]<0 || tmp[0]>M-1 || tmp[1]<0 || tmp[1]>N-1 || grid[tmp[0]][tmp[1]]=='0')
						continue;
					
					// 标记已遍历
					grid[tmp[0]][tmp[1]] = '0';
					
					// 入栈
					helper.push(new int[] {tmp[0]-1, tmp[1]});
					helper.push(new int[] {tmp[0]+1, tmp[1]});
					helper.push(new int[] {tmp[0], tmp[1]-1});
					helper.push(new int[] {tmp[0], tmp[1]+1});
				}
				
				// 统计岛屿数量
				ans++;
			}
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	char[][] grid = new char[][] {
    		{'1','1','0','0','0'},
    		{'1','1','0','0','0'},
    		{'0','0','1','0','0'},
    		{'0','0','0','1','1'}
    	};
    	
    	System.out.println(new Solution().numIslands(grid));
	}

}