package com.jasper.algs.contest.weekly.c141.qu1089.solu;

import java.util.stream.IntStream;

/**
 * 1089. 复写零
 * 
 * <p> 3 刷
 */
class Solution {
    public void duplicateZeros(int[] arr) {
    	
    }
    
    public static void main(String[] args) {
    	//                     1 0 0 2 3 0 0 4
//		int[] arr = new int[] {1,0,2,3,0,4,5,0};
		
		//                     1 2 3
//		int[] arr = new int[] {1,2,3};
		
		//                     8,4,5,0,0,0,0,0
		int[] arr = new int[] {8,4,5,0,0,0,0,7};
		
		new Solution().duplicateZeros(arr);
		
		IntStream.of(arr).forEach(System.out::println);
		
	}
}