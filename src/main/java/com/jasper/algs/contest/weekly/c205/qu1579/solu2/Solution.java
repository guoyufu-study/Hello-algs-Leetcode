package com.jasper.algs.contest.weekly.c205.qu1579.solu2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1579. 保证图可完全遍历
 * 
 * <p> 并查集 + 路径压缩 + 贪心算法
 */
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int m = edges.length;
        boolean[] used = new boolean[m];
        Arrays.sort(edges, (a,b) -> Integer.compare(b[0], a[0]));
        if(!UF(n, edges, 1, used)) return -1;
        if(!UF(n, edges, 2, used)) return -1;

        int ans = 0;
        for(boolean u : used) {
        	if(!u) ++ans; 
        }
        return ans;
    }

    boolean UF(int n, int[][] edges, int excludedType, boolean[] used) {
        int[] union = IntStream.rangeClosed(0, n).toArray();
        for(int i=0, cnt=0; i<edges.length; i++) {
            int[] edge = edges[i];
            if(edge[0]==excludedType) continue;
            int root1 = getRoot(union, edge[1]);
            int root2 = getRoot(union, edge[2]);
            if(root1!=root2) { // 合并两个分量
                ++cnt;// 选中此边
                used[i] = true;
                union[root1] = root2;//合并
            }
            if(cnt==n-1) return true; // 已连通
        }
        return false; // 未连通
    }

    int getRoot(int[] union, int idx) {
        while(union[idx]!=idx) {
            int root = getRoot(union, union[idx]);
            idx = union[idx] = root;
        }

        return idx;
    }
}