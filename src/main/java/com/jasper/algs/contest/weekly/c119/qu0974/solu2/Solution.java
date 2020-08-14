package com.jasper.algs.contest.weekly.c119.qu0974.solu2;

import java.util.HashMap;
import java.util.Map;

/**
 * 0974. 和可被 K 整除的子数组
 * 
 * <p> 前缀和 + 字典计数 + 逐一统计
 */
class Solution {

    public int subarraysDivByK(int[] A, int K) {
        
    	Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int num: A) {
            sum += num;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	// 7
		int[] A = new int[] {4,5,0,-2,-3,1};
		int K = 5;
		
		System.out.println(new Solution().subarraysDivByK(A, K));
	}
}