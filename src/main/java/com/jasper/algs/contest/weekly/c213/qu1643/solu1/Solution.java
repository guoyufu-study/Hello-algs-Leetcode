package com.jasper.algs.contest.weekly.c213.qu1643.solu1;

import java.util.Arrays;

/**
 * 1643. 第 K 条最小指令
 *
 * <p> 优先确定高位 + 组合计数
 */
class Solution {
	
	// 预处理组合数
    static int[][] C = new int[16][31];
    static {
        Arrays.fill(C[0], 1);
        for(int i=1; i<16; i++) {
            C[i][i] = 1;
            for(int j=i+1; j<31; j++) {
                C[i][j] = C[i][j-1] + C[i-1][j-1];
            }
        }
    }
    
    public String kthSmallestPath(int[] destination, int k) {
        
        int v = destination[0], h = destination[1];
        int len = h+v;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<len && k>0 && h-1>=0; i++) {
            if(C[h-1][h+v-1]>=k) {
                ans.append('H');
                h--;
            }
            else {
                ans.append('V');
                k -= C[h-1][h+v-1];
                v--;
            }
        }
        while(v-->0) ans.append('V');

        return ans.toString();
    }
}