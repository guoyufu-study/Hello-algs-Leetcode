package com.jasper.algs.contest.weekly.c119.qu0974.solu1;

/**
 * 0974. 和可被 K 整除的子数组
 * 
 * <p> 前缀和 + 字典计数 + 组合公式
 */
class Solution {

    int K;
    public int subarraysDivByK(int[] A, int K) {
        
        int n = A.length;
        this.K = K;

        // 前缀和 + 字典计数
        A[0] = getNumber(A[0]);
        int[] k = new int[K];
        k[A[0]]++;
        for(int i=1; i<n; i++) {
            A[i] = getNumber(A[i-1] + A[i]);
            k[A[i]]++;
        }

        // 统计差为0组合
        int ans = (k[0] + 1) * k[0] / 2;
        for(int i=1; i<K; i++) {
            ans += k[i] > 1 ? k[i] * (k[i]-1) / 2 : 0;
        }

        return ans;
    }

    int getNumber(int num) {
        num = num % K;
        return num>=0 ? num : K + num;
    }
    
    public static void main(String[] args) {
    	// 7
		int[] A = new int[] {4,5,0,-2,-3,1};
		int K = 5;
		
		System.out.println(new Solution().subarraysDivByK(A, K));
	}
}