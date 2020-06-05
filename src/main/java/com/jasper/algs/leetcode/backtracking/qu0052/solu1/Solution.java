package com.jasper.algs.leetcode.backtracking.qu0052.solu1;

/**
 * 0051. N皇后
 *
 * <p> 标记行列对角线
 */
class Solution {
	
	private int n ;
	private boolean[] rows, hills, dales;
	private int ans;
	
	public int totalNQueens(int n) {

		this.n = n;
		rows = new boolean[n];
		hills = new boolean[4 * n -1];
		dales = new boolean[2 * n -1];
		
		// 从第0行开始回溯
		backtracing(0);
		
		return ans;
    }

	private void backtracing(int row) {
		
		for (int column = 0; column < n; column++) {
			// 剪枝
			if(isUnderAttack(row, column))
				continue;
			
			// 放置皇后
			placeQueen(row, column);
			
			// 最后一个皇后
			if(row+1==n)
				ans++;
			
			// 放置下一个皇后
			else 
				backtracing(row+1);
			
			// 回溯
			removeQueen(row, column);
		}
	}

	// 移除皇后
	private void removeQueen(int row, int column) {
		rows[column] = false;
		hills[row-column+2*n] = false;
		dales[row+column] = false;
	}

	// 放置皇后
	private void placeQueen(int row, int column) {
		rows[column] = true;
		hills[row-column+2*n] = true;
		dales[row+column] = true;
	}

	// 判断是否被皇后攻击
	private boolean isUnderAttack(int row, int column) {
		return rows[column] || hills[row-column+2*n] || dales[row+column];
	}

	public static void main(String[] args) {
		
		// 1
//		int n = 1;
		
		// 0
//		int n = 3;
		
		// 2
//		int n = 4;
		
		// 92
		int n = 8;
		
		System.out.println(new Solution().totalNQueens(n));
	}
}