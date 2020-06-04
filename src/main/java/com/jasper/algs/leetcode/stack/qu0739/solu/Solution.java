package com.jasper.algs.leetcode.stack.qu0739.solu;

import java.util.stream.IntStream;

/**
 * 0739. 每日温度
 * 
 * <p> 2刷
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {

    	return T;
    }
    
    public static void main(String[] args) {
    	// 1, 1, 4, 2, 1, 1, 0, 0
    	int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		
		IntStream.of(T).forEach( t -> {
			System.out.print(t + ",");
		});
	}
}