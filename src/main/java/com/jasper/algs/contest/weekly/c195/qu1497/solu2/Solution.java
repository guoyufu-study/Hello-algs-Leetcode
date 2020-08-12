package com.jasper.algs.contest.weekly.c195.qu1497.solu2;

/**
 * 1497. 检查数组对是否可以被 k 整除
 * 
 * <p> 两数之和
 */
class Solution {
    public boolean canArrange(int[] arr, int k) {
    	
    	int[] mod = new int[k];
        for (int num : arr) {
            ++mod[(num % k + k) % k];
        }
        for (int i = 1; i + i < k; ++i) {
            if (mod[i] != mod[k - i]) {
                return false;
            }
        }
        return mod[0] % 2 == 0;
    }
    
    public static void main(String[] args) {
    	// true
		int[] arr = new int[] {-4,-7,5,2,9,1,10,4,-8,-3};
		int k = 3;
		
		System.out.println(new Solution().canArrange(arr, k));
	}
}