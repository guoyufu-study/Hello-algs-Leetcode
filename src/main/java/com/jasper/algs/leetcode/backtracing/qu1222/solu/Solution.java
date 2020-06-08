package com.jasper.algs.leetcode.backtracing.qu1222.solu;

import java.util.ArrayList;
import java.util.List;

/**
 * 1222. 可以攻击国王的皇后
 * 
 * <p> 2 刷
 */
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

    	return new ArrayList<List<Integer>>();
    }
    
    public static void main(String[] args) {
    	// [[0,1],[1,0],[3,3]]
    	int[][] queens = new int[][] {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
    	int[] king = new int[] {0,0};
    	
    	System.out.println(new Solution().queensAttacktheKing(queens, king));
	}
}