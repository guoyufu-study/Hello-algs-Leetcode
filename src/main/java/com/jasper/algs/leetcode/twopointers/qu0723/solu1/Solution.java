package com.jasper.algs.leetcode.twopointers.qu0723.solu1;

/**
 * 0723.粉碎糖果
 *
 * <p>
 * 滑动窗口 + 快慢指针
 */
class Solution {

	public int[][] candyCrush(int[][] board) {
		int R = board.length, C = board[0].length;
		// 标记每一行
		boolean todo = false;
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c + 2 < C; ++c) {
				int v = Math.abs(board[r][c]);
				if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
					board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
					todo = true;
				}
			}
		}
		// 标记每一列
		for (int c = 0; c < C; ++c) {
			for (int r = 0; r + 2 < R; ++r) {
				int v = Math.abs(board[r][c]);
				if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
					board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
					todo = true;
				}
			}
		}

		// 粉碎下落
		for (int c = 0; c < C; ++c) {
			int wr = R - 1;
			for (int r = R - 1; r >= 0; --r)
				if (board[r][c] > 0)// 下落
					board[wr--][c] = board[r][c];
			while (wr >= 0)// 空位置
				board[wr--][c] = 0;
		}

		return todo ? candyCrush(board) : board;
	}
}
