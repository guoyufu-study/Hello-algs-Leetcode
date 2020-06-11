package com.jasper.algs.contest.weekly.c191.qu1465.solu1;

import java.util.Arrays;

/**
 * 5425. 切割后面积最大的蛋糕
 * 
 * <p> 排序 + 找最大值
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		Arrays.sort(horizontalCuts);
    	Arrays.sort(verticalCuts);
    	
    	// 计算高度差
    	int m = horizontalCuts.length;
    	int[] hs = new int[m+1];
    	hs[0] = horizontalCuts[0];
    	for (int i = 1; i < m; i++) {
			hs[i] = horizontalCuts[i]-horizontalCuts[i-1];
		}
    	hs[m] = h - horizontalCuts[m-1];
    	
    	// 计算宽度差
    	int n = verticalCuts.length;
    	int[] vs = new int[n+1];
    	vs[0] = verticalCuts[0];
    	for (int i = 1; i < n; i++) {
			vs[i] = verticalCuts[i]-verticalCuts[i-1];
		}
    	vs[n] = w - verticalCuts[n-1];
    	
    	int hmax = 0;
    	for (int i = 0; i <= m; i++) {
			hmax = Math.max(hmax, hs[i]);
		}
    	int wmax = 0;
    	for (int i = 0; i <= n; i++) {
    		wmax = Math.max(wmax, vs[i]);
    	}
    	
    	return (int)((hmax*1L*wmax)%1_000_000_007);
    }
    
    public static void main(String[] args) {
    	// 4
    	int h = 5;
    	int w = 4;
    	int[] horizontalCuts = {1,2,4};
    	int[] verticalCuts = {1,3};
    	
    	// 6
//    	int h = 5;
//    	int w = 4;
//    	int[] horizontalCuts = {3,1};
//    	int[] verticalCuts = {1};
    	
    	// 9
//    	int h = 5;
//    	int w = 4;
//    	int[] horizontalCuts = {3};
//    	int[] verticalCuts = {3};
    	
    	System.out.println(new Solution().maxArea(h, w, horizontalCuts, verticalCuts));
	}
}