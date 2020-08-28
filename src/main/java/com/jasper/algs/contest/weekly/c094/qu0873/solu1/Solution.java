package com.jasper.algs.contest.weekly.c094.qu0873.solu1;

/**
 * 0873. 最长的斐波那契子序列的长度
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {
    	int n = A.length, ans = 0;;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) { // 枚举起始元素
                int a = A[i], b = A[j], sum = a+b, count = 2;
                for(int k=j+1; k<n; k++) {
                    if(sum == A[k]) {
                        count++;
                        a = b;
                        b = sum;
                        sum = a+b;
                    } else if(sum < A[k]) break; // 剪枝
                }
                ans = Math.max(ans, count);
            }
        }

        return ans<3 ? 0 : ans;
    }
}