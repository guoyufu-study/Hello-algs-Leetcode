package com.jasper.algs.leetcode.maths.qu0836.solu1;

/**
 * 0836. 矩形重叠
 * 
 * <p>
 * 一个矩形的左下角顶点，在另一个矩形的右上角顶点的左下方向
 *
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

    	return rec1[0] < rec2[2] && rec1[1] <rec2[3] && // rec1 左下角顶点，在rec2右上角顶点的左下方向上
    			rec2[0] < rec1[2] && rec2[1] <rec1[3]; // 同时，rec2 左下角顶点，在rec1右上角顶点的左下方向上
    }
}