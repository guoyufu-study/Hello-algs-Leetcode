package com.jasper.algs.contest.c191.qu5425.solu;

/**
 * 5425. 切割后面积最大的蛋糕
 * 
 * <p> 2 刷
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

    	return 0;
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