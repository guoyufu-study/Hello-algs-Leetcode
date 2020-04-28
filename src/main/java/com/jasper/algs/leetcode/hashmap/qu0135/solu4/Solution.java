package com.jasper.algs.leetcode.hashmap.qu0135.solu4;

/**
 * 135. 分发糖果（按评分分糖果）
 * 
 * <p> 常数空间
 */
class Solution {
    public int candy(int[] ratings) {
    	int N = ratings.length;
    	
    	// 上坡计数、下坡计数
    	int up=0, down=0;
    	// 标识上坡1、下坡-1、平地0
    	int old_slope=0;
    	// 从ratings[0]开始， 上坡、下坡、走平地
    	int ans = 1;
    	for (int i = 1; i < N; i++) {
    		//新上下坡动作
    		int new_slope = ratings[i]>ratings[i-1] ? 1 : ratings[i]==ratings[i-1] ? 0 : -1;
    		
    		// 汇总一个山峰
    		if((old_slope>0 && new_slope==0) // 上坡转平地
    				|| (old_slope<0 && new_slope>=0)) { // 下坡转上坡，或下坡转平地
    			ans += count(up) + count(down) + Math.max(up, down);
    			up = 0;
    			down = 0;
    		}
    		
    		// 绘制山峰
    		if(new_slope>0) up++;
    		else if(new_slope<0) down++;
    		else if(new_slope==0) ans++;
    		old_slope = new_slope;
		}
    	
    	// 汇总最后一个山峰
    	ans += count(up) + count(down) + Math.max(up, down);
    	
    	return ans;
    }

    private int count(int n) {
		return n*(n+1)/2;
	}


	public static void main(String[] args) {
		int[] ratings = new int[] {1,3,2,2,1}; //7
//		int[] ratings = new int[] {1,0,2};//5
		
		System.out.println(new Solution().candy(ratings));
	}
}