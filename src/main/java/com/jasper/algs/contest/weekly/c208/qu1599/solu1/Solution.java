package com.jasper.algs.contest.weekly.c208.qu1599.solu1;

/**
 * 1599. 经营摩天轮的最大利润
 * 
 * <p> 简单模拟计数
 */
class Solution {
	
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    	// 运行成本高于收益
    	if(boardingCost * 4 <= runningCost) return -1;
    	
    	int n = customers.length;
    	int ans = 0, maxProfit = 0; // 最高收益
    	int waiting = 0, profit = 0; // 等待人数、当前收益
    	
    	// 有新游客
    	for (int i = 0; i < n; i++) {
    		waiting += customers[i];
			int x = Math.min(waiting, 4);// 本次参与人数
			waiting -= x; // 剩余等待人数
			profit += x * boardingCost - runningCost;// 收益
			if(profit > maxProfit) { // 收益更高
				maxProfit = profit;
				ans = i+1;
			}
		}
    	
    	// 无新游客：完整轮次
    	int count = waiting/4;
    	if(count>0) {
    		int x = count * 4;// 本次参与人数
			waiting -= x; // 剩余等待人数
			profit += x * boardingCost - count * runningCost;// 收益
			if(profit > maxProfit) { // 收益更高
				maxProfit = profit;
				ans = n+count;// 注意不能在 ans 基础上自增，比如 [8, 0, 0, 20] 1 3
			}
    	}
    		
		// 无新游客：最后一个非完整轮次
    	if(waiting>0) {
			profit += waiting * boardingCost - runningCost;// 收益
			if(profit > maxProfit) { // 收益更高
				maxProfit = profit;
				ans = n+count+1;// 注意不能在 ans 基础上自增，比如 [8, 0, 0, 5] 2 1
			}
    	}
    		
    	return ans==0 ? -1 : ans;
    }
    
}