package com.jasper.algs.contest.weekly.c195.qu1497.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1497. 检查数组对是否可以被 k 整除
 * 
 * <p> 两数之和
 */
class Solution {
    public boolean canArrange(int[] arr, int k) {
    	
    	Map<Integer, Integer> mod = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int key = (num % k + k) % k;
			mod.put(key, mod.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : mod.entrySet()) {
            int t = entry.getKey(), occ = entry.getValue();
            if (t > 0 && mod.getOrDefault(k - t, 0) != occ) {
                return false;
            }
        }
        return mod.getOrDefault(0, 0) % 2 == 0;
    }
    
    public static void main(String[] args) {
    	// true
		int[] arr = new int[] {-4,-7,5,2,9,1,10,4,-8,-3};
		int k = 3;
		
		System.out.println(new Solution().canArrange(arr, k));
	}
}