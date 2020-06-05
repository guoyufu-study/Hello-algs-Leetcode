package com.jasper.algs.leetcode.backtracking.qu0051.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0051. N皇后
 *
 * <p>
 * 行列斜线标记
 */
class Solution {

	private int n;
	// 标记是否被列方向的皇后被攻击
	private boolean[] rows, 
	// 标记是否被主对角线方向的皇后攻击
	hills, 
	// 标记是否被次对角线方向的皇后攻击
	dales;
	// 皇后位置
	int[] queens;
	// 答案
	List<List<String>> ans = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {

		this.n = n;
		rows = new boolean[n];
		hills = new boolean[4 * n - 1];
		dales = new boolean[2 * n - 1];
		queens = new int[n];

		// 回溯：从第0行开始
		backtrack(0);

		return ans;
	}

	public void backtrack(int row) {

		for (int col = 0; col < n; col++) {
			// 剪枝
			if (isUnderAttack(row, col))
				continue;

			// 放置皇后
			placeQueen(row, col);

			// 最后一个皇后
			if (row + 1 == n)
				addSolution();

			// 放置下一个皇后
			else
				backtrack(row + 1);

			// 回溯
			removeQueen(row, col);
		}
	}

	/**
	 * 添加解决方案
	 */
	private void addSolution() {
		List<String> solution = new ArrayList<String>();
		
		for (int i = 0; i < n; ++i) {
			// (i,  queens[i]) 放置皇后
			int col = queens[i];
			
			// 按行构造答案
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < col; ++j)
				sb.append(".");
			sb.append("Q");
			for (int j = col+1; j < n; ++j)
				sb.append(".");
			solution.add(sb.toString());
		}
		
		ans.add(solution);
	}

	/**
	 * 放置皇后
	 */
	private void placeQueen(int row, int col) {
		queens[row] = col;
		rows[col] = true;
		hills[row - col + 2 * n] = true; // 主对角线
		dales[row + col] = true; // 次对角线

	}

	/**
	 * 移除皇后
	 */
	private void removeQueen(int row, int col) {
		queens[row] = 0;
		rows[col] = false;
		hills[row - col + 2 * n] = false; // 主对角线
		dales[row + col] = false; // 次对角线
	}

	/**
	 * 是否被攻击
	 */
	private boolean isUnderAttack(int row, int col) {
		return rows[col] || hills[row - col + 2 * n] || dales[row + col];
	}

	public static void main(String[] args) {
		
		// 1
		int n = 1; // hills = new boolean[4 * n - 1]; 注意避免数组越界
		// 2
//		int n = 4;

		new Solution().solveNQueens(n).stream().forEach(list -> {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			System.out.println();
		});
	}
}