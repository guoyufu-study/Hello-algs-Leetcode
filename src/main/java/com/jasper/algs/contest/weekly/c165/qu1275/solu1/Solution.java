package com.jasper.algs.contest.weekly.c165.qu1275.solu1;

/**
 * 1275. 找出井字棋的获胜者
 * 
 * <p> 模拟
 */
class Solution {
    public String tictactoe(int[][] moves) {

    	int n = moves.length;
    	if(n<5)
    		return "Pending";
    	
    	int row = moves[n-1][0];
		int col = moves[n-1][1];
		int hill = row + col;
		int valley = row -col;
		int rows = 0, cols = 0, hills = 0, valleys = 0;
		
		int i = n%2==0 ? 1 : 0;
		for(; i<n; i+=2) {
			if(row == moves[i][0])
				rows++;
			if(col == moves[i][1])
				cols++;
			if(hill == moves[i][0]+moves[i][1]) 
				hills++;
			if(valley == moves[i][0] - moves[i][1]) 
				valleys++;
		}
    	
		if(rows==3 || cols==3 || hills==3 || valleys==3)
			return n%2==0 ? "B" : "A";
		
		return n==9 ? "Draw" : "pending";
    }
}