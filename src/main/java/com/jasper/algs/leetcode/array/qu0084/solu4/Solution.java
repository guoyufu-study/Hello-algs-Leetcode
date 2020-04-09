package com.jasper.algs.leetcode.array.qu0084.solu4;

/**
 * 优化分治算法
 */
class Solution {
	public int largestRectangleArea(int[] height) {
        return largestRectangleArea(height,0,height.length - 1);
    }

    private int largestRectangleArea(int[] height, int start, int end) {
        if (start > end) {
            return 0;
        }
        boolean sorted = true;
        int minHeight = height[start];
        int minIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (height[i - 1] > height[i]) {//判断是否有序
                sorted = false;
            }
            if (minHeight > height[i]) {
                minHeight = height[i];
                minIndex = i;
            }
        }
        int result = 0;
        if (sorted) {//简化有序数组的情况
            for (int i = start; i <= end; i++) {
                result = Math.max(result, height[i] * (end - i + 1));
            }
        } else {
            int leftMax = largestRectangleArea(height, start, minIndex - 1);
            int rightMax = largestRectangleArea(height, minIndex + 1, end);
            result = Math.max(minHeight * (end - start + 1), Math.max(leftMax, rightMax));
        }
        return result;
    }
}