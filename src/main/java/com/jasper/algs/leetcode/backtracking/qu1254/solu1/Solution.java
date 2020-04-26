package com.jasper.algs.leetcode.backtracking.qu1254.solu1;

/**
 * 1254. 统计封闭岛屿的数目
 *	
 * <p> DFS 递归
 */
class Solution {
	public int closedIsland(int[][] grid) {
		// 边界
        if(grid == null || grid.length == 0){
            return 0;
        }

        int num = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0 && !dfs(grid,i,j)){
                    //如果dfs搜索完了发现这个岛不是接触边界，则封闭岛屿数增加
                    num++;   
                }
            }
        }
        return num;
    }

    //返回岛屿是否到达边界
    public boolean dfs(int[][] grid,int i, int j) {
        if (i < 0 || i >=  grid.length || j >= grid[0].length || j < 0 ) {
            //是否到达边界，一次dfs搜索中只要有一个地方最终走到这儿就不是封闭岛屿了
            return true;
        }
        //如果是海洋或是已经访问过的陆地则返回false，因为这两种情况不需要继续遍历，且也没找到边界
        if(grid[i][j] != 0){
            return false;
        }
        //当前是陆地则继续
        //标记为2表示已经访问过，也有人标记为海洋，但我觉得用一个独立的值更清晰些
        grid[i][j] = 2;
        
        boolean res1 = dfs(grid,i-1,j);
        boolean res2 = dfs(grid,i+1,j);
        boolean res3 = dfs(grid,i,j+1);
        boolean res4 = dfs(grid,i,j-1);
        //四方向遍历下去的结果，有任意一个方向接触边界就行;
        return res1 || res2 || res3 || res4; 
    }
}