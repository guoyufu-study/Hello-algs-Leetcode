package com.jasper.algs.leetcode.dp.qu0931.solu1;

/**
 * 0931. 下降路径最小和
 * 
 * <p> 动态规划
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
    	int N = A.length;
    	if(N==1) return A[0][0];
    	for (int i = 1; i < N; i++) {
    		A[i][0] += Math.min(A[i-1][0], A[i-1][1]);
    		A[i][N-1] += Math.min(A[i-1][N-2], A[i-1][N-1]);
			for (int j = 1; j < N-1; j++) {
				A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
			}
		}
    	
    	int ans = 100_000;
    	for (int j = 0; j < N; j++) {
			ans = Math.min(ans, A[N-1][j]);
		}
    	return ans;
    }
    
    public static void main(String[] args) {
    	//  12
		int[][] A = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(new Solution().minFallingPathSum(A));
	}
}