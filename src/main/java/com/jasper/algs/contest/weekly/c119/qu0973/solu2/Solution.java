package com.jasper.algs.contest.weekly.c119.qu0973.solu2;

import java.util.PriorityQueue;

/**
 * 0973. 最接近原点的 K 个点
 * 
 * <p> 大顶堆
 */
class Solution {
	public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>((a, b) -> b-a);
        for(int[] p : points) {
            maxQ.offer(dist(p));
            if(maxQ.size()>K) maxQ.poll();
        }
        
        int distK = maxQ.poll();

        int[][] ans = new int[K][2];
        int t = 0, n = points.length;
        for (int i = 0; i < n; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}