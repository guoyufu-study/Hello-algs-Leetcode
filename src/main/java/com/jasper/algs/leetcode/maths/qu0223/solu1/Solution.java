package com.jasper.algs.leetcode.maths.qu0223.solu1;

/**
 * 0223. 矩形面积
 * <p>
 * 分别计算两个矩形面积，再减去重叠面积
 *
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
    	// 两个矩形面积和
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        
        // 矩形不重叠
        if (E > C || F > D || G < A || H < B) {
            return area;
        }

        // 矩形重叠
        int lx = Math.max(A, E);
        int by = Math.max(B, F);
        int rx = Math.min(C, G);
        int ty = Math.min(D, H);

        return area - (rx - lx) * (ty - by);
    }
}