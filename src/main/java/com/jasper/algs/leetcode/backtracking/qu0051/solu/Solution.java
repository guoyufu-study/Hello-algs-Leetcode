package com.jasper.algs.leetcode.backtracking.qu0051.solu;

import java.util.ArrayList;
import java.util.List;

/**
 * 0051. N皇后
 *
 * <p> 2刷
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {

    	List<List<String>> ans = new ArrayList<>();

    	
    	return ans;
    }

	public static void main(String[] args) {
		int n = 4;
		
		new Solution().solveNQueens(n).stream()
			.forEach( list -> {
				for (int i = 0; i < list.size(); i++) {
					System.out.print(list.get(i) + "   ");
				}
				System.out.println();
			});
	}
}