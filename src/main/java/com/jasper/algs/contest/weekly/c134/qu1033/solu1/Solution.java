package com.jasper.algs.contest.weekly.c134.qu1033.solu1;

/**
 * 1033. 移动石子直到连续
 * 
 * <p> 数学
 */
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        // 求距离
        int x = Math.abs(a-b);
        int y = Math.abs(b-c);
        int z = Math.abs(c-a);

        // 最大移动次数
        int max = Math.max(Math.max(x, y), z)-2;
        // 最小移动次数
        int min = max==0 ? 0 : 
            Math.min(Math.min(x, y), z)<=2 ? 1 : 2;

        return new int[] {min, max};
    }
}