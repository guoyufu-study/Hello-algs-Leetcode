package com.jasper.algs.interview.q0064.solu1;

import java.util.stream.IntStream;

class Solution {
    public int sumNums(int n) {
    	// 不符合要求，内部使用了if、else
    	return IntStream.rangeClosed(1, n).sum();
    }
}