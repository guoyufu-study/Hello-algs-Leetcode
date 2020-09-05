package com.jasper.algs.contest.biweekly.bc34.qu1574.solu1;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 * 
 * <p> 
 */
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // 左 -> 右
        int l2r = 1;
        while(l2r < n) 
            if(arr[l2r-1] <= arr[l2r]) l2r++;
            else break;
        
        if(n==l2r) return 0; // 非递减

        // 右 -> 左
        int r2l = 1;
        while(r2l < n)
            if(arr[n - r2l - 1] <= arr[n - r2l]) r2l++;
            else break;

        int r1 = l2r - 1, l2 = n - r2l;

        // (左->右) or (右 -> 左)
        int len = Math.max(l2r, r2l);

        // or (part(左 -> 右) + part(右 -> 左))
        for(int i=r1,j=n-1; i>=0; i--) {
            while(j>=l2) {
                if(arr[i] <= arr[j]) {
                    l2r++;
                    len = Math.max(len, l2r);
                    j--;
                } else break;
            }
            l2r--;
        }
        return n - len;
    }
}