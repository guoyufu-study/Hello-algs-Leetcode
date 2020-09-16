package com.jasper.algs.sword2offer.qu064.solu1;

import java.util.stream.IntStream;

class Solution {
	
	public int sumNums(int n) {
		// 不符合要求，内部使用了if、else
		return IntStream.rangeClosed(1, n).sum();
	}

	public static void main(String[] args) {

		// 50005000
		int n = 10000;

		System.out.println(new Solution().sumNums(n));

	}
}