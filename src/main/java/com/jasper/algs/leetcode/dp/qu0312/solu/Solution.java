package com.jasper.algs.leetcode.dp.qu0312.solu;

/**
 * 0312.戳气球
 * 
 * <p> 6 刷 
 */
class Solution {
    public int maxCoins(int[] nums) {
    	
    	return 0;
    }
    
    public static void main(String[] args) {
//		int[] nums = new int[] {3,1,5,8}; //maxCoins = 167
		
		int[] nums = {3,4,5,6,7,5,7,8,5,3,2,5};//maxCoins = 1918
		
    	// 回溯法用时：15491
        long start = System.currentTimeMillis();
        System.out.println("最多能得到金币："+new Solution().maxCoins(nums));
		System.out.println("原始回溯用时   ：   " + String.valueOf(System.currentTimeMillis() - start)/* +"  运算次 数："+sum3 */);
        		
//        start = System.currentTimeMillis();
//        System.out.println(maxCoins4MS(nums));
//        System.out.println("分治用时   ：   " + 
//        String.valueOf(System.currentTimeMillis() - start)+"  运算次数："+sum1+"  实际运算次数："+sum2);
	}
}