package com.jasper.algs.contest.weekly.c086.qu0841.solu1;

import java.util.List;

/**
 * 0841. 钥匙和房间
 * 
 * <p> DFS
 */
class Solution {
	
	boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

}