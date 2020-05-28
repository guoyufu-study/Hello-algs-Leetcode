package com.jasper.algs.leetcode.greedy.qu1029.solu1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. 两地调度
 * 
 * <p> 贪心算法
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {

    	// 升序排序
//    	Arrays.sort(costs, (a,b) -> (a[0]-a[1]) - (b[0]-b[1]));
    	Arrays.sort(costs, Comparator.comparingInt(i -> (i[0] - i[1])));
    	
    	int N = costs.length/2;
    	int ans = 0;
    	// 去A地
		for (int i = 0; i < N; i++)
			ans += costs[i][0];
		// 去B地
		for (int i = N; i < costs.length; i++)
			ans += costs[i][1];
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 110
		int[][] costs = new int[][] {{10,20},{30,200},{400,50},{30,20}};
		
		System.out.println(new Solution().twoCitySchedCost(costs));
	}
}