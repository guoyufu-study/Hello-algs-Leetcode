package com.jasper.algs.leetcode.dp.qu0265.solu1;

/**
 * 0265.粉刷房子 II
 * 
 * <p> 动态规划
 */
class Solution {
    public int minCostII(int[][] costs) {
    	// 边界
    	if(costs==null || costs.length==0 // 无房
    			|| costs[0].length==0) // 无颜色
    		return 0;
    	if(costs[0].length==1) // 只有一色
    		return costs.length==1 ? costs[0][0] : -1;
    		
    	int n = costs.length;
    	int k = costs[0].length;
    	
    	// 0 最小、 1 次小
    	int[] min = getMin(costs, 0);
    	for (int i = 1; i < n; i++) {
			for (int j = 0; j < k; j++) {
				costs[i][j] += j!=min[0] ? costs[i-1][min[0]] : costs[i-1][min[1]];
			}
			
			min = getMin(costs, i);
		}
    	
    	return costs[n-1][min[0]];
    }
    
    /**
     * 第i行的最小值和次小值
     */
    private int[] getMin(int[][] costs, int i) {
		int length = costs[0].length;
		assert costs.length > 0  && length >=2;
		
		// 前两列
		int[] min = new int[] {0,1};
		if(costs[i][0]>costs[i][1])
			min = new int[] {1,0};
		// 其它列
		for (int j = 2; j < length; j++) {
			if(costs[i][j]<costs[i][min[1]]) {
				if(costs[i][j] < costs[i][min[0]]) {
					min[1] = min[0];
					min[0] = j;
				} else {
					min[1] = j;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
    	// 5
		int[][] costs = new int[][] {{1,5,3},{2,9,4}};
		
		// 2
//		int[][] costs = new int[][] {{17,9,6,2,6,18,8,12,3,5,9,11,20,8,13,16}};
		
		System.out.println(new Solution().minCostII(costs));
	}
}