package com.jasper.algs.leetcode.backtracing.qu0036.solu1;

/**
 * 0036. 有效的数独
 * 
 * <p> 辅助数组
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9], cols = new boolean[9][9], rc = new boolean[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]!='.') {
                    int digit = board[i][j] - '1';
                    if(rows[i][digit] || cols[j][digit] || rc[i/3+j/3*3][digit]) 
                        return false;
                    rows[i][digit] = cols[j][digit] = rc[i/3+j/3*3][digit] = true;
                }  
            }
        }

        return true;
    }
}