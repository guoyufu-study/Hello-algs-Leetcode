package com.jasper.algs.leetcode.array.qu0419.solu1;

/**
 * 0419. 甲板上的战舰
 * 
 * <p> 遍历
 */
class Solution {
    public int countBattleships(char[][] board) {
        if(board.length==0) return 0;
        int n = board.length, m = board[0].length;

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j]=='.') continue; // 不是战舰
                if((i-1>=0 && board[i-1][j]=='X') || (j-1>=0 && board[i][j-1]=='X')) continue; // 再次遇到同一战舰
                // 第一次遇到战舰
                ans++;
            }
        }

        return ans;
    }
}