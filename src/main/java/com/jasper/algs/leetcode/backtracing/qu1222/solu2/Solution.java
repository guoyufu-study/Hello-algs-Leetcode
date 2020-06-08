package com.jasper.algs.leetcode.backtracing.qu1222.solu2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 * 
 * <p> 八个方向遍历
 */
class Solution {
	
	private static int N = 8;
	
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    	// 皇后
    	boolean[][] helper = new boolean[N][N];
    	for (int[] queen : queens) {
			helper[queen[0]][queen[1]] = true;
		}
    	// 八个方向
    	int[][] directions = new int[][] {
    		// 从左到右，从上到下
    		{-1, -1}, // 左上
    		{-1, 0}, // 上
    		{-1, 1}, // 右上
    		
    		{0, -1},  // 左
    		{0, 1}, // 右 
    		
    		{1, -1}, // 左下
    		{1, 0}, // 下
    		{1, 1}, // 右下
    	};
    	
    	ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    	for (int i = 0; i < directions.length; i++) {
			int x=king[0], y=king[1];
			for (; x>=0 && x<N && y>=0 && y<N; 
					x+=directions[i][0], y+=directions[i][1]) {
				if(!helper[x][y]) continue;
				
				// 找到可以攻击的皇后
				ans.add(Arrays.asList(x,y));
				break;
			}
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// [[0,1],[1,0],[3,3]]
//    	int[][] queens = new int[][] {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
//    	int[] king = new int[] {0,0};

		// [[2, 3], [1, 4], [1, 6], [3, 7], [4, 3], [5, 4],[4,5]]
		int[][] queens = new int[][] {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
		int[] king = new int[] {3,4};
    	    	
    	System.out.println(new Solution().queensAttacktheKing(queens, king));
	}
}