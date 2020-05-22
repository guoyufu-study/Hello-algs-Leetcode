package com.jasper.algs.leetcode.backtracking.qu0079.solu1;

/**
 * 0079. 单词搜索
 * <p> 回溯
 */
class Solution {
	
	// 偏移量：上左右下
	//  		x-1,y
	// x,y-1 	 x,y    x,y+1
	//        	x+1,y
	private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	//行列
	private int m, n;
	
    public boolean exist(char[][] board, String word) {
    	//行列
    	m = board.length;
    	n = board[0].length;
    	
    	// 辅助标记
    	boolean[][] marked = new boolean[m][n];
    	
    	// 搜索
    	for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {// 枚举所有起始位置
            	// 找到，即返回
                if (dfs(board, i, j, marked, word, 0)) return true;
            }
        }
    	
    	return false;
    }

    /**
     * DFS 深度优先搜索
     * 
     * @param board		表盘
     * @param i			行
     * @param j			列
     * @param marked	辅助标记
     * @param word		单词
     * @param start		索引
     * @return
     */
	private boolean dfs(char[][] board, int i, int j, boolean[][] marked, String word, int start) {
		// 终止条件
		if(start==word.length()-1)
			return board[i][j] == word.charAt(start);
		
		// 成功走一步
		if (board[i][j] == word.charAt(start)) {
			// 标记
            marked[i][j] = true;
            
            // 下一步
            for (int k = 0; k < 4; k++) {
            	// 新坐标
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                
                if (inArea(newX, newY) && //未越界
                		!marked[newX][newY] && // 未被标记
                		dfs(board, newX, newY, marked, word, start + 1)) {
                        return true;
                }
            }
            
            // 回溯
            marked[i][j] = false;
        }
		
		// 失败
		return false;
	}

	private boolean inArea(int x, int y) {
        return x >= 0 && x < m 
        		&& y >= 0 && y < n;
    }

}