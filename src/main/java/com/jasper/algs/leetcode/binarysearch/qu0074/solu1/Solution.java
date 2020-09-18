package com.jasper.algs.leetcode.binarysearch.qu0074.solu1;

/**
 * 0074. 搜索二维矩阵
 * 
 * <p> 二分查找
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        // 二分查找
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            int i = mid/n, j = mid%n;
            if(matrix[i][j] < target) left = mid + 1;
            else if(matrix[i][j] > target) right = mid - 1;
            else return true;
        }

        return false;
    }
}