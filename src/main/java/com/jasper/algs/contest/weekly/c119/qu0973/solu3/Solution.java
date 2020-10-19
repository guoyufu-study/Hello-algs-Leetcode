package com.jasper.algs.contest.weekly.c119.qu0973.solu3;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 0973. 最接近原点的 K 个点
 * 
 * <p> 仿快排分治
 */
class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        int sz = points.length;
        if (sz > K) {
            work(0, sz - 1, K);
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    public void work(int i, int j, int K) {
        if (i >= j) return;
        int oi = i, oj = j;
        // 随机选取一个基准，并计算距离
        int pivot = dist(ThreadLocalRandom.current().nextInt(i, j));

        while (i < j) {
            while (i < j && dist(i) < pivot) i++;
            while (i < j && dist(j) > pivot) j--;
            int distI = dist(i);
            // 如此存在距离相等并且和基准距离一样的应该退出循环
            if (distI == dist(j) && distI == pivot) {
                break;
            }
            swap(i, j);
        }
        // 左边元素够使用
        if (K <= i - oi + 1)
            work(oi, i, K);
        else
            work(i+1, oj, K - (i - oi + 1));
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0], t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}