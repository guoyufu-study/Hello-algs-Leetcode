package com.jasper.algs.contest.weekly.c208.qu1599.solu2;

/**
 * 1599. 经营摩天轮的最大利润
 * 
 * <p> 简单模拟计数：精简代码
 */
class Solution {
	int ans, maxProfit; // 最高收益
	int waiting, profit; // 等待人数、当前收益
	int boardingCost, runningCost;
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
    	// 运行成本高于收益
    	if(boardingCost * 4 <= runningCost) return -1;
    	
    	this.boardingCost = boardingCost;
    	this.runningCost = runningCost;
    	int n = customers.length;
    	
    	// 有新游客
    	for (int i = 0; i < n; i++) {
    		waiting += customers[i];
			rotate(Math.min(waiting, 4), 1, i+1);
		}
    	
    	// 无新游客：完整轮次
    	int count = waiting/4;
    	if(count>0)
    		rotate(count*4, count, n+count);// 注意不能在 ans 基础上自增，比如 [8, 0, 0, 20] 1 3
		
		// 无新游客：最后一个非完整轮次
    	if(waiting>0)
    		rotate(waiting, 1, n+count+1);// 注意不能在 ans 基础上自增，比如 [8, 0, 0, 5] 2 1
		
    	return ans==0 ? -1 : ans;
    }
    
    /**
     * 转动摩天轮
     * 
     * @param x 本次参与人次
     * @param count 本次转动多少轮
     * @param sum 总共转动了多少轮
     */
    void rotate(int x, int count, int sum) {
    	waiting -= x; // 剩余等待人数
		profit += x * boardingCost - count * runningCost;// 收益
		if(profit > maxProfit) { // 收益更高
			maxProfit = profit;
			ans = sum;
		}
    }
}