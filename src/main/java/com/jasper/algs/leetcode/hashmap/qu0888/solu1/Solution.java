package com.jasper.algs.leetcode.hashmap.qu0888.solu1;

/**
 * 0888. 公平的糖果交换
 * 
 * <p> 方程求解
 */
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
    	
    	// A, B 各自的和
    	int sa = 0, sb = 0;
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // 如果 Alice 给出 x, 她应该收到 x + delta

        // 辅助字典
        boolean[] bSet = new boolean[100001];
        for (int x: B) bSet[x]=true;

        // 交换糖果
        for (int x: A)
            if (x+delta>0 && x+delta<100000 && bSet[x + delta])
                return new int[]{x, x + delta};

    	throw new IllegalArgumentException("没有正确答案！");
    }
}