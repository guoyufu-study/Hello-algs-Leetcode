package com.jasper.algs.leetcode.greedy.qu0452.solu1;

import java.util.Arrays;

/**
 * 0452. 用最少数量的箭引爆气球
 * 
 * <p> 贪心算法
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        // 结束坐标排序
        Arrays.sort(points, (a,b)->a[1]>b[1] ? 1 : -1);
        
        // 贪心算法
        int end = points[0][1], ans = 1;;
        for(int[] point : points) {
            if(point[0]>end) {
                ++ans;
                end = point[1];
            }
        }
        return ans;
    }
}