package com.jasper.algs.contest.weekly.c172.qu1323.solu1;


/**
 * 1323. 6 和 9 组成的最大数字
 * 
 * <p>找到最高位6
 */
class Solution {
    public int maximum69Number (int num) {
    	int count = 0;
    	int max6Bit = 0;
    	int tmp = num;
    	while(tmp % 10 != 0) {
    		count++;
    		if(tmp % 10 == 6)
    			max6Bit = count;
    		
    		tmp /= 10;
    	}
    	
    	
    	return num + (max6Bit == 0 ? 0 : 3 * (int)Math.pow(10, max6Bit-1));
    }
}