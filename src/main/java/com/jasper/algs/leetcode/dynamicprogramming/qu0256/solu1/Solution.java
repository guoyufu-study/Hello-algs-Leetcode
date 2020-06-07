package com.jasper.algs.leetcode.dynamicprogramming.qu0256.solu1;

/**
 * 0256. 粉刷房子
 * 
 * <p> 动态规划
 */
class Solution {
    public int minCost(int[][] costs) {
    	// 边界
        if (costs.length == 0) return 0;
        // 前一行
        int[] previousRow = costs[costs.length -1];

        for (int n = costs.length - 2; n >= 0; n--) {
        	// 当前行
            int[] currentRow = costs[n].clone();
            // 刷红花费
            currentRow[0] += Math.min(previousRow[1], previousRow[2]);
            // 刷绿花费
            currentRow[1] += Math.min(previousRow[0], previousRow[2]);
            // 刷蓝花费
            currentRow[2] += Math.min(previousRow[0], previousRow[1]);
            // 当前行 => 前一行
            previousRow = currentRow;
        }  

        return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
    }

	public static void main(String[] args) {
    	// 10
		int[][] costs = new int[][] {{17,2,17},{16,16,5},{14,3,19}};
		
		System.out.println(new Solution().minCost(costs));
	}
}