package com.jasper.algs.contest.weekly.c192.qu1471.solu1;

import java.util.Arrays;

/**
 * 1471. 数组中的 k 个最强值
 * 
 * <p>
 * 排序+找中位数+双指针
 */
class Solution {
	public int[] getStrongest(int[] arr, int k) {
		
		// 排序
		Arrays.sort(arr);
		// 定位中位数
		int mind = arr[(arr.length - 1) / 2];
		
		// 双指针
		int[] ans = new int[k];
		int l = 0, r = arr.length - 1;
		while (k>0) {
			ans[--k] = mind - arr[l] > arr[r] - mind ? arr[l++] : arr[r--];
		}
		
		return ans;
	}
}