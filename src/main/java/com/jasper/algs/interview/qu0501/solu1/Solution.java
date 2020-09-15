package com.jasper.algs.interview.qu0501.solu1;

/**
 * 面试题 05.01. 插入
 * 
 * <p> 位运算
 */
class Solution {
    public int insertBits(int N, int M, int i, int j) {
                int tail = ((N >> i << i) ^ N) ;
                int mid = (M << i);
                int head = j == 31 ? 0 : ((N >> (j + 1)) << (j + 1)); //  因为用 5 位保存右移位数，右移 32 位 相当于右移 0 位。 不变
        return  head | mid | tail;
    }
    
}