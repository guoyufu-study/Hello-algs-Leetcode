package com.jasper.algs.contest.weekly.c135.qu1037.solu1;

/**
 * 1037. 有效的回旋镖
 * 
 * <p> 数学
 */
class Solution {
	
    public boolean isBoomerang(int[][] points) {
        int[] x = points[0];
        int[] y = points[1];
        int[] z = points[2];

        return x[0] * y[1] - x[1] * y[0] + (x[1]-y[1]) * z[0] - (x[0]-y[0]) * z[1] != 0;
    }
}