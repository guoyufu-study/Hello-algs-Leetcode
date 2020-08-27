package com.jasper.algs.contest.weekly.c203.qu1562.solu1;

/**
 * 1562. 查找大小为 M 的最新分组
 *
 */
class Solution {
    public int findLatestStep(int[] arr, int m) {
    	int n = arr.length;
    	// 缓存边界
        int[] starts = new int[n+1];// 存起点 [start, index]
        int[] ends = new int[n+1]; // 存终点 [index, end]
        int count = 0, ans = -1;
        for(int i=0; i<n; i++) {
            // 找左右边界
            int start = arr[i], end = arr[i]; // 两侧都是0
            int left = arr[i]-1;
            if(left>0 && starts[left] !=0) { // 左侧不是0
                start = starts[left];
                if(arr[i] - start == m) {// 左侧1长度是m
                    count--;
                }
            }
            int right = arr[i]+1;
			if(right <= n && ends[right]!=0) { // 右侧不是0
                end = ends[right];
                if(end - arr[i] == m) {// 右侧1长度是m
                    count--;
                }
            }
			
			if(end-start+1==m) count++; // 新串长度是m
            if(count>0) ans = i+1; // 存在长度是m的1串
            
			// 更新边界
            starts[end] = start;
            ends[start] = end;
        }

        return ans;
    }
}