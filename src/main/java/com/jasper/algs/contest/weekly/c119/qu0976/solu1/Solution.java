package com.jasper.algs.contest.weekly.c119.qu0976.solu1;

import java.util.Arrays;

/**
 * 0976. 三角形的最大周长
 * 
 * <p> 排序+贪心
 */
class Solution {
    public int largestPerimeter(int[] A) {
        // 贪心算法
        Arrays.sort(A);
        int n = A.length;
        for(int i=n-1; i-2>=0; i--) {
            if(A[i]<A[i-1]+A[i-2])
                return A[i]+A[i-1]+A[i-2];
        }
        return 0;
    }
}