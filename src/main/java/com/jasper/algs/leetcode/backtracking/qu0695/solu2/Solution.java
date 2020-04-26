package com.jasper.algs.leetcode.backtracking.qu0695.solu2;

import java.util.Stack;

/**
 * 0695. 岛屿的最大面积
 *
 *	<p>DFS 深度优先搜索+辅助栈
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    	
    	int M = grid.length;
    	if(M<1) return 0; // 边界
    	int N = grid[0].length;
    	
    	// 辅助栈
    	Stack<int[]> helper = new Stack<>();
    	int ans = 0;
    	for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				// 跳过水域
				if(grid[r][c]==0) continue;
				
				// 入栈
				helper.push(new int[] {r, c});
				
				// 计算岛屿面积
				int areaOfIsland = 0;
				while(!helper.isEmpty()) {
					int[] tmp = helper.pop();
					if(tmp[0] < 0 || tmp[0] > M-1 || tmp[1] < 0 || tmp[1] > N-1 || grid[tmp[0]][tmp[1]] == 0)
						continue;
					// 标记已遍历
					grid[tmp[0]][tmp[1]] = 0;
					// 记录陆地块面积
					areaOfIsland++;
					// 入栈
					helper.push(new int[] {tmp[0]-1, tmp[1]});
					helper.push(new int[] {tmp[0]+1, tmp[1]});
					helper.push(new int[] {tmp[0], tmp[1]-1});
					helper.push(new int[] {tmp[0], tmp[1]+1});
				}
				
				
				// 更新最大岛屿面积
				if(ans < areaOfIsland)
					ans = areaOfIsland;
			}
		}
    	
    	return ans;
    }
	
	public static void main(String[] args) {
//		int[][] grid = new int[][] {
//				{0,1},};
				
			int[][] grid = new int[][] {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,0,1,1},
				{0,0,0,1,1}};
		
		System.out.println(new Solution().maxAreaOfIsland(grid));
	}
}