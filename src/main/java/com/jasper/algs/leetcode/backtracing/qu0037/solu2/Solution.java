package com.jasper.algs.leetcode.backtracing.qu0037.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0037. 解数独
 * 
 * <p> 回溯 + 位运算优化
 */
class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[][] rc = new int[3][3];
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
    	// 已填充
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        // 填充唯一选项
        boolean modified = false;
        while (!modified) {
        	modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] != '.') continue;
                    int mask = ~(rows[i] | cols[j] | rc[i / 3][j / 3]) & 0x1ff;
                    if ((mask & (mask - 1)) == 0) {
                        int digit = Integer.bitCount(mask - 1);
                        flip(i, j, digit);
                        board[i][j] = (char) (digit + '0' + 1);
                        modified = true;
                    }
                }
            }
        }

        // 空格
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    boolean dfs(char[][] board, int pos) {
        if (pos == spaces.size()) return true;

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(rows[i] | cols[j] | rc[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            if(dfs(board, pos + 1)) return true;
            flip(i, j, digit);
        }
        return false;
    }

    public void flip(int i, int j, int digit) {
        rows[i] ^= (1 << digit);
        cols[j] ^= (1 << digit);
        rc[i / 3][j / 3] ^= (1 << digit);
    }
}