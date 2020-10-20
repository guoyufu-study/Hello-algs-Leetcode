package com.jasper.algs.contest.biweekly.bc12.qu1245.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1245. 树的直径
 * 
 * <p> 两次BFS
 */
class Solution {
    
    @SuppressWarnings("unchecked")
	public int treeDiameter(int[][] edges) {
        int n = edges.length;
        if(n==0) return 0;
        List<Integer>[] adjs = new List[n+1];
        for(int i=0; i<=n; i++) adjs[i] = new ArrayList<Integer>();
        for(int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }
        
        // 找最远节点
        int sn = edges[0][0];
        boolean[] visited = new boolean[n+1];// 标记已访问
        visited[sn] = true;
        Deque<Integer> queue = new LinkedList<>();// 记录在访问
        queue.offer(sn);
        while(!queue.isEmpty()) {
            int size = queue.size();
            sn = queue.peek();
            for(int i=0; i<size; i++) {
                List<Integer> nn = adjs[queue.poll()];
                for(int node : nn) {
                    if(!visited[node]) {
                        queue.offer(node);
                        visited[node] = true;
                    }
                }
            }
        }

        // 找最大直径
        int ans = 0;
        visited = new boolean[n+1];// 标记已访问
        visited[sn] = true;
        queue.offer(sn);//记录在访问
        while(!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                List<Integer> nn = adjs[queue.poll()];
                for(int node : nn) {
                    if(!visited[node]) {
                        queue.offer(node);
                        visited[node] = true;
                    }
                }
            }
        }
     
        return ans-1;
    }
}