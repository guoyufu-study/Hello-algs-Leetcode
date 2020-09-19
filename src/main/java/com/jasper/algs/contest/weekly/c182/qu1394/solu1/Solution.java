package com.jasper.algs.contest.weekly.c182.qu1394.solu1;

/**
 * 1394. 找出数组中的幸运数
 * 
 * <p> 字典计数 + 遍历查找
 */
class Solution {
    public int findLucky(int[] arr) {
        int[] map = new int[501];
        for(int num : arr) map[num]++;
        for(int i=500; i>0; i--) 
            if(i==map[i])
                return i;

        return -1;
    }
}