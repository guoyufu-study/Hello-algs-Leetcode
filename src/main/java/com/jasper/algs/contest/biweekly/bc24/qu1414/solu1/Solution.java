package com.jasper.algs.contest.biweekly.bc24.qu1414.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1414.和为 K 的最少斐波那契数字数目
 * 
 * <p> 贪心算法
 */
class Solution {
	
    @SuppressWarnings("serial")
	public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        List<Integer> fib = new ArrayList<Integer>() {{add(1); add(1);}};
    	while(a+b<=k) {
    		int c = a + b;
    		fib.add(c);
    		a = b;
    		b = c;
    	}
    	
    	int ans = 0;
    	for (int i = fib.size()-1; i >= 1; i--) {
			if(k>fib.get(i)) {
				++ans;
				k -= fib.get(i);
				i--;
			} else if(k==fib.get(i)) return ++ans;
		}
    	return 0;
    }
}