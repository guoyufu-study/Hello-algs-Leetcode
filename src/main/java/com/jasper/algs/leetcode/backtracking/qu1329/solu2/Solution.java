package com.jasper.algs.leetcode.backtracking.qu1329.solu2;

/**
 * 1329. 将矩阵按对角线排序
 * <p>直接排序
 */
class Solution {
	public int[][] diagonalSort(int[][] mat) {
		
		// 边界处理
    	if(mat==null || mat.length==0)
    		return mat;
        int N = mat.length;
        int M = mat[0].length;

        // 第0行元素为起点
        for (int i = 0; i < M; i++) {
            int up = 0, left = i;
            int right = Math.min(left + N - 1, M - 1);
            int down = right - left;
            specialQuickSort(mat, up, left, down, right);
        }
        
        // 第0列元素为起点
        for (int i = 0; i < N; i++) {
            int up = i, left = 0;
            int down = Math.min(up + M - 1, N - 1);
            int right = down - up;
            specialQuickSort(mat, up, left, down, right);
        }
        return mat;
    }

    public void specialQuickSort(int[][] a, int up, int left, int down, int right) {
        //(up, left) 是左上角元素的坐标，(down, right) 是右下角元素的坐标
        if (left > right) {
            return;
        }
        int t = a[up][left];
        int x1 = up, i = left, x2 = down, j = right;
        while (i != j) {
            while (a[x2][j] >= t && j > i) {
                x2--;
                j--;
            }
            while (a[x1][i] <= t && j > i) {
                x1++;
                i++;
            }
            if (i < j) {
                swap(a, x1, i, x2, j);
            }
        }
        swap(a, up, left, x1, i);
        specialQuickSort(a, up, left, x1 - 1, i - 1);
        specialQuickSort(a, x1 + 1, i + 1, down, right);
    }

    public void swap(int[][] a, int up, int left, int down, int right) {
        int t = a[up][left];
        a[up][left] = a[down][right];
        a[down][right] = t;
        return;
    }
}
