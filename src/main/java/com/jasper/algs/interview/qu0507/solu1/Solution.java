package com.jasper.algs.interview.qu0507.solu1;

/**
 * 面试题 05.07. 配对交换
 * 
 * <p> 位运算 + 掩码
 */
class Solution {
    public int exchangeBits(int num) {

        return ((num & 0x2AAAAAAA) >> 1) | ((num & 0x15555555) << 1);
    }
}