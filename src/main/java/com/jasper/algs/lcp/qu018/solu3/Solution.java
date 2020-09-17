package com.jasper.algs.lcp.qu018.solu3;

/**
 * LCP 18. 早餐组合
 * 
 * <p> 辅助字典
 */
class Solution {
    private static final long MOD = 1_000_000_007;
	public int breakfastNumber(int[] staple, int[] drinks, int x) {
    	// 价格 <= index 的饮料数量
    	int[] countDrinks = new int[x];
    	for (int drink : drinks) 
    		if(drink < x) countDrinks[drink]++;
    	for (int i = 2; i < x; i++) 
			countDrinks[i] += countDrinks[i-1];
		
    	// 组合数量
    	long ans = 0;
    	for (int i = 0; i < staple.length; i++) {
    		if(x <= staple[i]) continue;
			ans += countDrinks[x - staple[i]];
		}
    	return (int)(ans%MOD);
    }
}