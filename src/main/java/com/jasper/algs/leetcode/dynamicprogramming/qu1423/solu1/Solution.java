package com.jasper.algs.leetcode.dynamicprogramming.qu1423.solu1;

/**
 * 1423. 可获得的最大点数
 * 
 * <p>动态规划
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
    	
    	int N = cardPoints.length;
    	
    	// 从尾部取卡牌，求和
    	int[] helper = new int[k+1];
    	helper[k] = 0;
    	for (int i=N-1, j=k-1; j>=0; i--,j--) {
			helper[j] = helper[j+1] + cardPoints[i];
		}
    	
    	
    	int sum = 0;
    	for (int i=0, j=1; j<k+1; i++,j++) {
    		// 从头部取卡牌，求和
    		sum += cardPoints[i];
    		// 求总和
			helper[j] += sum;
		}
    	
    	// 取最大和
    	int ans = 0;
    	for (int i = 0; i <= k; i++) {
			ans = Math.max(ans, helper[i]);
		}
    	return ans;
    }
    
    
    public static void main(String[] args) {
    	//202
//		int [] cardPoints = new int[] {1,79,80,1,1,1,200,1};
//		int k = 3;
		
    	//1
//		int [] cardPoints = new int[] {1,1000,1};
//		int k = 1;
		
    	//55
//		int [] cardPoints = new int[] {9,7,7,9,7,7,9};
//		int k = 7;
		
    	//4
//		int [] cardPoints = new int[] {2,2,2};
//		int k = 2;
    	
    	//12
		int [] cardPoints = new int[] {1,2,3,4,5,6,1};
		int k = 3;
		System.out.println(new Solution().maxScore(cardPoints, k ));
	}
}