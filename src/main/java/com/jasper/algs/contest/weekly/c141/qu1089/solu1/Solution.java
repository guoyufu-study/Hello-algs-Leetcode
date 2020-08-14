package com.jasper.algs.contest.weekly.c141.qu1089.solu1;

import java.util.stream.IntStream;

/**
 * 1089. 复写零
 * 
 * <p> 双指针
 */
class Solution {
    public void duplicateZeros(int[] arr) {
    	
    	int n = arr.length, slow = 0, fast = 0;
        while(fast < n) {
            if(arr[slow]==0) fast++;
            slow++;
            fast++;
        }
        
        if(slow>=n) return ;
        
        slow--;
        fast--;
        while(slow>=0) {
        	if(fast<n) arr[fast] = arr[slow];
 		   fast--;
    	   if(arr[slow]==0) {
    		   if(fast<n) arr[fast] = 0;
    		   fast--;
    	   } 
    	   slow--;
        }
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