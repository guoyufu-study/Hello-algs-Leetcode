package com.jasper.algs.contest.weekly.c170.qu1310.solu1;

/**
 * 1310. 子数组异或查询
 * 
 * <p> 前缀异或和
 */
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

    	int n = arr.length;
        int[] pre = new int[n + 1];
        //计算每个位置的前缀和 pre[i] 表示前i项的异或和
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] querie : queries){
            //前面多异或的部分，再重复异或一次就可以抵消了
            //假设 求 [1, 2]，那么对于 [0, 2] 来说就是多异或了 [0, 0] 这个结果
            //根据 两个相同值异或结果为 0，那么我们可以再异或一次 [0, 0] 就将 [0, 0] 给抵消掉了
            //pre[querie[0]]代表了[0, 0]异或 pre[querie[1] + 1]代表了[0, 2]异或 其中[0, 0]异或两次
            //最后相当于[1, 2]异或
            ans[i++] = pre[querie[0]] ^ pre[querie[1] + 1];
        }
        return ans;
    }
}