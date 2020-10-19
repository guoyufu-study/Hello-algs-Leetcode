package com.jasper.algs.contest.biweekly.bc35.qu1588.solu3;

/**
 * 1588. 所有奇数长度子数组的和
 * 
 * <p> 数学计算
 */
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, ans = 0;
        for(int i=0; i<n; i++) {
        	int left = i+1, right = n-i;
        	ans += (((left+1)/2) * ((right+1)/2) // 左右都取奇数个元素
        			+ (left/2) * (right/2)) * arr[i]; // 左右都取偶数个元素
        }
        
        return ans;
    }
}