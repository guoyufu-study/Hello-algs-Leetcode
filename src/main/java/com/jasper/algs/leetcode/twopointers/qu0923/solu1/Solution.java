package com.jasper.algs.leetcode.twopointers.qu0923.solu1;


/**
 * 0923. 三数之和的多种可能
 *
 * <p> 左右指针
 */
class Solution {
    public int threeSumMulti(int[] A, int target) {
    	
    	int MOD = 1_000_000_007;
    	
    	int N = 0;
    	int[] count = new int[101];
    	for (int num : A) {
			count[num]++;
			if(count[num]==1)
				N++;
		}
    	
    	int[] keys = new int[N];
    	for (int num : count) {
			if(count[num]!=0)
				keys[--N] = num;
		}
    	
    	// 三数之和
    	long ans = 0;
    	for (int i = 0; i < keys.length; i++) {
    		int x = keys[i];
            int T = target - x;
            int j = i, k = keys.length - 1;
            while (j <= k) {
                int y = keys[j], z = keys[k];
                if (y + z < T) { // 小了
                    j++;
                } else if (y + z > T) { // 大了
                    k--;
                } else {  // # x+y+z == T 计算
                    if (i < j && j < k) {
                        ans += count[x] * count[y] * count[z];
                    } else if (i == j && j < k) {
                        ans += count[x] * (count[x] - 1) / 2 * count[z];
                    } else if (i < j && j == k) {
                        ans += count[x] * count[y] * (count[y] - 1) / 2;
                    } else {  // i == j == k
                        ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                    }

                    ans %= MOD;
                    j++;
                    k--;
                }
            }
        }

        return (int) ans;

    }
}