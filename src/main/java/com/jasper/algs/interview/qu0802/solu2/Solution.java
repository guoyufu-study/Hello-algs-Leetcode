package com.jasper.algs.interview.qu0802.solu2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 08.02. 迷路的机器人
 * 
 * <p> 动态规划
 */
class Solution {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        // 是否存在路径
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = obstacleGrid[0][0]==0;
        for(int i=1; i<n; i++) {
            dp[i][0] = obstacleGrid[i][0]==0 && dp[i-1][0];
        }

        for(int i=0; i<n; i++) {
            for(int j=1; j<m; j++) {
                dp[i][j] = obstacleGrid[i][j]==0 && ((i>0 && dp[i-1][j]) || dp[i][j-1]);
            }
        }

        // 无路径
        if(!dp[n-1][m-1]) return new LinkedList<>();

        // 有路径，构造
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        int i = n-1, j= m-1;
        while(i>0 || j>0) {
            ans.add(0, Arrays.asList(i, j));
            if(i>0 && dp[i-1][j]) i--;
            else if(j>0 && dp[i][j-1]) j--;
        }
        ans.add(0, Arrays.asList(0,0));

        return ans;
    }
}