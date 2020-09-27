package com.jasper.algs.contest.weekly.c208.qu1599.solu3;

/**
 * 1599. 经营摩天轮的最大利润
 * 
 * <p> 简单模拟计数：精简代码
 */
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    	// 运行成本高于收益
    	if(boardingCost * 4 <= runningCost) return -1;
    	
    	int index = 0, n = customers.length;
    	int ans = 0, maxProfit = 0; // 最高收益
    	int waiting = 0, profit = 0; // 等待人数、当前收益
    	while (index<n || waiting > 0) {
    		if(index<n) // 有新游客到来
    			waiting += customers[index];
    		
			int x = Math.min(4, waiting); // 本轮参与人数
			
			// 参与
			index++; // 转动一轮
			waiting -= x; // 剩余等待人数
			profit += x * boardingCost - runningCost;// 收益
			if(profit > maxProfit) { // 收益更高
				maxProfit = profit;
				ans = index;
			}
		}
    	
    	return ans==0 ? -1 : ans;
    }
}