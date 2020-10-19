package com.jasper.algs.contest.weekly.c087.qu0845.solu1;

/**
 * 0845. 数组中的最长山脉
 * 
 * <p> 遍历计数
 */
class Solution {
    public int longestMountain(int[] A) {
        int n = A.length;
        int index = 0, ans = 0;
        while(index+1 < n) {
            while(index+1<n && A[index]==A[index+1]) index++;

            int asc = 0;
            while(index+1<n && A[index]<A[index+1]) {
                asc++;
                index++;
            }

            int desc = 0;
            while(index+1<n && A[index] > A[index+1]) {
                desc++;
                index++;
            }

            if(asc>=1 && desc>=1) 
                ans = Math.max(ans, asc+desc+1);
        }

        return ans;
    }
}