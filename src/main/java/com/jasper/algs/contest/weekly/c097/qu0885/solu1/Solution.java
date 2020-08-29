package com.jasper.algs.contest.weekly.c097.qu0885.solu1;

/**
 * 0885. 螺旋矩阵 III
 * 
 * <p>模拟
 */
class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    	int[] dr = new int[] {0, 1, 0, -1};
    	int[] dc = new int[] {1, 0,-1,  0};
    	int size = R*C;
		int[][] ans = new int[size][2];
    	int index = 0;
    	
    	ans[index++] = new int[] {r0, c0};
    	if(size==1) return ans;
    	
    	int dir = 0; // 方向
    	while(index<size) {
    		int sl = dir/2 + 1; // 步长
    		int di = dir % 4; // 方向索引
    		for(int j=0; j<sl; j++) { // 步进
				r0 += dr[di];
				c0 += dc[di];
				if(0<=r0 && r0<R && 0<=c0 && c0<C) {
					ans[index++] = new int[] {r0, c0};
				} 
			}
    		dir++;// 改变方向
    	}
    	
    	return ans;
    }
}