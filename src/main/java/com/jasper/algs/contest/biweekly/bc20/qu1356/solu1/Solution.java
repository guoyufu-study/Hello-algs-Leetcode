package com.jasper.algs.contest.biweekly.bc20.qu1356.solu1;

import java.util.stream.IntStream;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * 
 * <p> 排序
 */
class Solution {
    public int[] sortByBits(int[] arr) {
        return IntStream.of(arr)
            .map(x -> (Integer.bitCount(x)<<16) + x)
            .sorted()
            .map(x -> x & 0xFFFF)
            .toArray();
    }
}