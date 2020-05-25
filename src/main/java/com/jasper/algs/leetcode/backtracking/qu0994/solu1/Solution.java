package com.jasper.algs.leetcode.backtracking.qu0994.solu1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0994. 腐烂的橘子
 *
 * <p>
 * BFS 广度优先搜索
 * <p>
 * 队列中使用(-1,-1)标识一层结束
 */
class Solution {

	// 行列
	private int m = 0, n = 0;

	public int orangesRotting(int[][] grid) {
		m = grid.length;
		n = grid[0].length;

		// 偏移量：上下左右
		int[][] offset = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		// 初始化
		Queue<int[]> helper = new LinkedList<>();
		int fresh = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2)
					helper.add(new int[] { i, j });
				else if(grid[i][j]==1) {
					fresh++;
				}
			}
		}
		helper.add(new int[] { -1, -1 });

		int count = 0;
		while(helper.size()!=1) {
			// 腐烂的橘子
			int[] tmp = helper.poll();
			// 一层处理完毕
			if(tmp[0]==-1 && tmp[1]==-1) {
				helper.add(new int[] {-1, -1});
				count++;
				tmp = helper.poll();
			}
			
			// 相邻橘子
			for (int off = 0; off < offset.length; off++) {
				// 相邻坐标
        		int i = offset[off][0] + tmp[0];
        		int j = offset[off][1] + tmp[1];
        		// 新鲜橘子腐烂
				if(isValid(i,j) && grid[i][j]==1) {
					fresh--;
					// 标识
					grid[i][j] = 2;
					// 入队
					helper.add(new int[] {i,j});
				}
			}
		}
		
		return fresh!=0 ? -1 : // 还有新鲜橘子
				count;
	}

	private boolean isValid(int i, int j) {
		return i >= 0 && i < m && j >= 0 && j < n;
	}
}