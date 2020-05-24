package com.jasper.algs.leetcode.greedy.qu134.solu1;

/**
 * 0134. 加油站
 *
 * <p> 贪心算法
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	
    	int N = gas.length;
    	
    	// 差 dp[i] = gas[i] - cost[i]
    	for (int i = 0; i < N; i++) {
			gas[i] -= cost[i];
		}
    	
    	// 前缀和 sum
    	for (int i = 1; i < N; i++) {
			gas[i] += gas[i-1];
		}
    	
    	// 无法跑完全程
    	if(gas[N-1]<0) return -1;
    	
    	// 最小值所在索引
    	int ans = 0;
    	for (int i = 1; i < N; i++) {
			if(gas[i]<gas[ans]) {
				ans = i;
			}
		}
    	return (ans+1)%N;
    }
    
    public static void main(String[] args) {
    	
    	// 3
		int[] gas = new int[] {1,2,3,4,5};
		int[] cost = new int[] {3,4,5,1,2};
		
		// -1
//		int[] gas = new int[] {3,3,4};
//		int[] cost = new int[] {3,4,4};
		
		System.out.println(new Solution().canCompleteCircuit(gas, cost));
	}
}