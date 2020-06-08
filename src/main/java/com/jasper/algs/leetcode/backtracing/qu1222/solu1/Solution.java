package com.jasper.algs.leetcode.backtracing.qu1222.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 * 
 * <p> 遍历皇后
 */
class Solution {
	
	private ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

    	int row = king[0];
    	int column = king[1];
    	int hill = row-column;
    	int dale = row+column;
    	
    	int[] row_ans = new int[] {-1, 8};
    	int[] column_ans = new int[] {-1, 8};
    	int[] hill_ans = new int[] {-1, 8};
    	int[] dale_ans = new int[] {-1, 8};
    	for (int[] queen : queens) {
    		// 同行
			if(queen[0]==row) {
				row_ans[0] = queen[1]<column ? Math.max(row_ans[0], queen[1]) : row_ans[0];
				row_ans[1] = queen[1]>column ? Math.min(row_ans[1], queen[1]) : row_ans[1];
			} 
			// 同列
			if(queen[1]==column) {
				column_ans[0] = queen[0]<row ? Math.max(column_ans[0], queen[0]) : column_ans[0];
				column_ans[1] = queen[0]>row ? Math.min(column_ans[1], queen[0]) : column_ans[1];
			}
			// 同主对角线
			if(queen[0]-queen[1]==hill) {
				hill_ans[0] = queen[0]<row ? Math.max(hill_ans[0], queen[0]) : hill_ans[0];
				hill_ans[1] = queen[0]>row ? Math.min(hill_ans[1], queen[0]) : hill_ans[1];
			}
			// 同次对角线
			if(queen[0]+queen[1]==dale) {
				dale_ans[0] = queen[0]<row ? Math.max(dale_ans[0], queen[0]) : dale_ans[0];
				dale_ans[1] = queen[0]>row ? Math.min(dale_ans[1], queen[0]) : dale_ans[1];
			}
		}
    	
    	
    	fill(hill_ans, hill, true);
    	fill(row, row_ans);
    	fill(dale_ans, dale, false);
    	fill(column_ans, column);
		return ans;
    }
    
    private void fill(int[] array, int hill, boolean isHill) {
    	for (int row : array) {
			if(row==-1 || row==8) continue;
			
			if(isHill) {
				fill(row, row-hill);
			} else {
				fill(row, hill-row);
			}
			
		}
    	
	}

	private void fill(int[] array, int column) {
    	for (int row : array) {
			if(row>-1 && row<8) {
				fill(row, column);
			}
		}
	}

	private void fill(int row, int column) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(row);
		list.add(column);
		ans.add(list);
	}

	private void fill(int row, int[] array) {
    	
    	for (int column : array) {
			if(column>-1 && column<8) {
				fill(row, column);
			}
		}
	}

	public static void main(String[] args) {
    	// [[0,1],[1,0],[3,3]]
//    	int[][] queens = new int[][] {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
//    	int[] king = new int[] {0,0};
    	
		// [[2, 3], [1, 4], [1, 6], [3, 7],         [5, 4], [4, 5]]
		// [[2, 3], [1, 4], [1, 6], [3, 7], [4, 3], [5, 4],[4,5]]
    	int[][] queens = new int[][] {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
    	int[] king = new int[] {3,4};
		
    	System.out.println(new Solution().queensAttacktheKing(queens, king));
	}
}