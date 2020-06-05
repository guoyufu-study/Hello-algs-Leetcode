package com.jasper.algs.leetcode.backtracing.qu1020.solu0;

/**
 * DFS 淹掉所有非飞地
 * <p>遍历统计飞地
 */
class Solution {
    public int numEnclaves(int[][] A) {
        
    	// 边界
    	int rows = A.length;
    	if(rows<=2) return 0;
    	int cols = A[0].length;
    	if(cols<=2) return 0;
        
    	// 淹掉左侧和右侧
        for (int i = 0; i < rows; i++) {
            dfs(A, i, 0);
            dfs(A, i, cols - 1);
        }
        
        // 淹掉上方和下方
        for (int j = 0; j < cols; j++) {
            dfs(A, 0, j);
            dfs(A, rows - 1, j);
        }

        // 统计飞地
        int ans = 0;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                ans += A[x][y];
            }
        }

        return ans;
    }

    /**
     *  DFS 淹掉陆地
     *  
     * @param A
     * @param r 行
     * @param c 列
     */
    private void dfs(int[][] A, int r, int c) {
        if (r < 0 || c < 0 || r >= A.length || c >= A[0].length) {
            return;
        }
        if (A[r][c] == 0) {
            return;
        }
        A[r][c] = 0;
        dfs(A, r + 1, c);
        dfs(A, r, c + 1);
        dfs(A, r - 1, c);
        dfs(A, r, c - 1);
    }
}