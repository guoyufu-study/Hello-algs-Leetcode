package com.jasper.algs.leetcode.backtracing.qu1020.solu1;


/**
 * 1020. 飞地的数量
 *	
 * <p>DFS 递归
 */
class Solution {
    public int numEnclaves(int[][] A) {
    	// 边界
    	int rows = A.length;
    	if(rows<=2) return 0;
    	int cols = A[0].length;
    	if(cols<=2) return 0;
    	
    	int ans = 0;
    	for (int r = 1; r < rows-1; r++) {
    		for (int c = 1; c < cols-1; c++) {
				// 跳过水域
    			if(A[r][c] == 0) continue;
    			
    			// 统计飞地数量
    			int dfs = dfs(A, rows, cols, r, c);
    			ans += dfs < 0 ? 0 : dfs;
			}
		}
    	
    	return ans;
    }

	private int dfs(int[][] A, int rows, int cols, int r, int c) {
		// 遇到边界终止
		if((r==0 || r==rows-1 || c==0 || c==cols-1) && A[r][c] == 1) {
			return -250000;
		}
		
		// 遇到水域终止
		if(A[r][c] == 0) return 0;
		
		// 标记已遍历
		A[r][c] = 0;
		
		// 统计飞地
		return dfs(A, rows, cols, r-1, c)
				+ dfs(A, rows, cols, r+1, c)
				+ dfs(A, rows, cols, r, c-1)
				+ dfs(A, rows, cols, r, c+1)
				+ 1;
	}
}