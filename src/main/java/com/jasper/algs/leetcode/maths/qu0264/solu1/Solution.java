package com.jasper.algs.leetcode.maths.qu0264.solu1;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 0264. 丑数 II
 *
 * <p>
 * 辅助堆
 */
class Solution {
	
	private static final Ugly u = new Ugly();
	
	public int nthUglyNumber(int n) {
		
		return u.nums[n-1];
	}
	
	static class Ugly {
		
		int[] nums = new int[1690];

		Ugly() {
			// 辅助字典
			HashSet<Long> seen = new HashSet<>();
			seen.add(1L);
			// 优先队列
			PriorityQueue<Long> heap = new PriorityQueue<Long>();
			heap.add(1L);

			// 质数
			int[] primes = new int[] { 2, 3, 5 };
			long currUgly, newUgly;
			for (int i = 0; i < 1690; ++i) {
				currUgly = heap.poll();
				nums[i] = (int) currUgly;
				for (int prime : primes) {
					newUgly = currUgly * prime;
					if (!seen.contains(newUgly)) {
						seen.add(newUgly);
						heap.add(newUgly);
					}
				}
			}
		}
	}


	public static void main(String[] args) {
		int n = 1690;
		System.out.println(new Solution().nthUglyNumber(n));
	}
}

