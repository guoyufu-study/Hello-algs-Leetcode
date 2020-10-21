package com.jasper.algs.contest.weekly.c205.qu1579.solu1;

/**
 * 1579. 保证图可完全遍历
 * 
 * <p> 并查集 + 路径压缩 + 贪心算法
 */
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF uf1 = new UF(n), uf2 = new UF(n), uf3 = new UF(n);
        int cnt = 0, c1 = 0, c2 = 0;
        for (int[] edge : edges) {
            int type = edge[0], from = edge[1]-1, to = edge[2]-1;
            if(type == 3) cnt += uf3.union(from, to) ? 1 : 0;   // type3 重复边数量
            if(type == 1) c1++;  // type1 边数量
            if(type == 2) c2++;  // type2 边数量
            if(type == 1 || type == 3) uf1.union(from, to); // Alice
            if(type == 2 || type == 3) uf2.union(from, to); // Bob
        }
        if(uf3.count == 1) return c1 + c2 + cnt;
        if(uf1.count == 1 && uf2.count == 1) {
            return cnt + (c1 - uf3.count  + 1) + (c2 - uf3.count + 1);
        }
        return -1;
    }
    // DSU 模板
    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        //修改 ： 与通常返回值不同 true : type3 重复！
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return true;

            parent[rootQ] = rootP;
            count--;
            return false;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                x = parent[x] = parent[parent[x]];
            }
            return x;
        }
    }
}