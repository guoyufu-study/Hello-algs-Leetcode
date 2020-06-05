package com.jasper.algs.leetcode.backtracing.qu0200.solu;

/**
 * 0200. 岛屿数量
 *
 * <p> 2 刷
 */
class Solution {
    public int numIslands(char[][] grid) {
    	
    	
    	return 0;
    }
    
    public static void main(String[] args) {
    	// 3
//    	char[][] grid = new char[][] {
//    		{'1','1','0','0','0'},
//    		{'1','1','0','0','0'},
//    		{'0','0','1','0','0'},
//    		{'0','0','0','1','1'}
//    	};
    	
    	// 1
    	char[][] grid = new char[][] {
    		{'1','1','1','1','0'},
    		{'1','1','0','1','0'},
    		{'1','1','0','0','0'},
    		{'0','0','0','0','0'}
    	};
    	
    	System.out.println(new Solution().numIslands(grid));
	}

}