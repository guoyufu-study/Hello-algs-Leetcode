package com.jasper.algs.leetcode.backtracking.qu0994.solu2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0994. 腐烂的橘子
 *
 * <p> BFS 广度优先搜索
 * <p> 找出最晚腐烂的橘子
 */
class Solution {
	
	// 行列
	private int m=0,n=0;
	
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        // 偏移量：上下左右
        int[][] offset = new int[][] {{-1,0}, {1,0},{0,-1},{0,1}};
        // 初始化
        Queue<int[]> helper = new LinkedList<>();
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j]==2)
					helper.add(new int[] {i, j});
			}
		}
        
        while(!helper.isEmpty()) {
        	// 出队
        	int[] tmp = helper.poll();
        	// 新标识值
        	int v = grid[tmp[0]][tmp[1]] + 1;
        	
        	for (int off = 0; off < offset.length; off++) {
        		// 相邻坐标
        		int i = offset[off][0] + tmp[0];
        		int j = offset[off][1] + tmp[1];
        		// 新鲜橘子腐烂
				if(isValid(i,j) && grid[i][j]==1) {
					// 标识
					grid[i][j] = v;
					// 入队
					helper.add(new int[] {i,j});
				}
			}
        }
        
        // 构造结果
        int max = 0;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 有新鲜橘子
				if(grid[i][j] == 1)
					return -1;
				// 最晚腐烂的橘子
				max = Math.max(max, grid[i][j]);
			}
		}
        
    	return max==0 ? 0 // 一个橘子都没有
    			: max-2;
    }

	private boolean isValid(int i, int j) {
		return i>=0 && i<m 
				&& j>=0 && j<n;
	}
}