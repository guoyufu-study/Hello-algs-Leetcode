package com.jasper.algs.contest.weekly.c120.qu0977.solu2;

/**
 * 0977. 有序数组的平方
 *
 * <p> 双指针
 */
class Solution {
	public int[] sortedSquares(int[] A) {
        
		int left = 0, n = A.length, right = n-1;
        int[] ans = new int[n];
        while(left<=right) {
            int l = A[left] * A[left];
            int r = A[right] * A[right];
            if(l<r) {
                ans[--n] = r;
                right--;
            } else {
                ans[--n] = l;
                left++;
            }
        }
        return ans;
    }
}